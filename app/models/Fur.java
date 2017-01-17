package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by jingguo on 1/2/17.
 */
/*Fur bought in*/
@Entity
public class Fur extends Model {
    @Id
    public Integer id;
    public long date;
    public String gender;
    public String color;
    public double price;
    public String note;
    public Integer amount;

    public static Model.Finder<String, Fur> find = new Model.Finder<>(
            Fur.class);

    public static Fur getFurById(Integer id){
        return find.byId(id.toString());
    }

    public static List<Fur> getAllFur(){
        return Fur.find.where().findList();
    }
}
