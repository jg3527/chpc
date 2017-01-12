package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class FurOrder extends Model {
    @Id
    public Integer id;
    @OneToOne
    @JoinColumn(name = "id")
    public Fur fur;
    public Integer amount;

    public static Model.Finder<String, FurOrder> find = new Model.Finder<>(
            FurOrder.class);

    public static FurOrder getFurOrderById(Integer id) {
        return FurOrder.find.where().eq("id", id).findUnique();
    }

}
