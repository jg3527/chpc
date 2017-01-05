package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class FurOrder extends Model {
    @Id
    public Integer id;
    public Fur fur;
    public Integer amount;
}
