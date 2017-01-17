package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CreateException;
import models.Clothes;
import models.Fur;
import play.Logger;
import play.libs.Json;

import java.lang.reflect.Field;

/**
 * Created by jingguo on 1/9/17.
 */
public class HomeFacade {

    public void addEditFurOrder(JsonNode jsonNode){
        Fur fur = null;

        if (jsonNode.hasNonNull("id")) {
            fur = Fur.getFurById(jsonNode.get("id").asInt());
        }

        if (fur != null) {
            jsonToModel(jsonNode, fur);
            fur.update();
        } else {
            fur = new Fur();
            jsonToModel(jsonNode, fur);
            fur.save();
        }

        Logger.debug(String.format("Saved fur %s", fur.id));
    }

    public JsonNode getAllFur() {
        return Json.toJson(Fur.getAllFur());
    }

    public void addEditClothes(JsonNode jsonNode) {
        Clothes clothes = null;
        if (jsonNode.hasNonNull("id")) {
            clothes = Clothes.getClothesById(jsonNode.get("id").asInt());
        }

        if (clothes != null) {
            jsonToModel(jsonNode, clothes);
            clothes.update();
        } else {
            clothes = new Clothes();
            jsonToModel(jsonNode, clothes);
            clothes.save();
        }
    }

    public void addSaleRecord(JsonNode jsonNode){

    }

    /*
        public <T extends Model> void jsonToModel(JsonNode jsonNode, T entity) {
            Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
            try {
                while (iterator.hasNext()) {
                    Map.Entry<String, JsonNode> entry = iterator.next();
                    String fieldName = entry.getKey();

                    Field field = entity.getClass().getDeclaredField(fieldName);
                    field.set(entity, field.getDeclaringClass().cast(entry.getValue()));
                }
                entity.save();
                Logger.debug(String.format("Created %s entity based on Json %s", entity.getClass().getName(), jsonNode.toString()));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    public <T extends Model> T jsonToModel(JsonNode jsonNode, Class<T> entityClass) throws CreateException {

        try {
            T entity = entityClass.newInstance();
            Field[] fields = entity.getClass().getFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                if (jsonNode.hasNonNull(fieldName)) {
                    field.set(entity, field.getType().cast(jsonNode.get(fieldName)));
                }
            }
            entity.save();
            Logger.debug(String.format("Created %s entity based on Json %s", entityClass.getName(), jsonNode.toString()));
            return entity;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        throw new CreateException(String.format("Failed to create entity of class %s from json %s", entityClass.getName(), jsonNode.toString()));
    }*/
    public <T extends Model> void jsonToModel(JsonNode jsonNode, T entity){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T entity2 = (T) mapper.convertValue(jsonNode, entity.getClass());
        setObject(entity, entity2);
    }

    public <E1, E2> void setObject(E1 entity1, E2 entity2) {
        Field[] fields = entity1.getClass().getFields();
        for (Field field : fields) {
            try {
                field.set(entity1, field.get(entity2));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
