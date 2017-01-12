package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CreateException;
import models.Fur;
import models.FurOrder;
import play.Logger;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jingguo on 1/9/17.
 */
public class HomeFacade {

    public void addEditFurOrder(JsonNode jsonNode) throws CreateException {
        Fur fur = new Fur();
        FurOrder furOrder = null;
        if (jsonNode.hasNonNull("id")) {
            furOrder = FurOrder.getFurOrderById(jsonNode.get("id").asInt());
        }

        jsonToModel(jsonNode, fur);

        if (furOrder != null) {
            fur.update();
            furOrder.fur = fur;
            furOrder.amount = jsonNode.get("amount").asInt();
            furOrder.update();
        } else {
            fur.save();
            furOrder = new FurOrder();
            furOrder.fur = fur;
            furOrder.amount = jsonNode.get("amount").asInt();
            furOrder.save();
        }

        Logger.debug(String.format("Saved furOrder %s", furOrder.fur.id));

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
    public <T extends Model> void jsonToModel(JsonNode jsonNode, T entity) throws CreateException {
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
