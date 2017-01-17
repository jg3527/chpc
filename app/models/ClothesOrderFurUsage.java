package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by jingguo on 1/11/17.
 */
@Entity
public class ClothesOrderFurUsage extends Model {
    @Id
    public Integer id;
    public Fur fur;
    public Integer amount;
    @ManyToOne
    public Clothes clothes;
}
