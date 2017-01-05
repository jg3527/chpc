package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/2/17.
 */
/*Fur bought in*/
@Entity
public class Fur extends Model {
    @Id
    public Integer id;
    public Date date;
    public String gender;
    public String color;
    public Integer amount;
    public double price;
    public String note;
    public FurOrder order;
}
