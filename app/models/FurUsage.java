package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jingguo on 1/16/17.
 */
@Entity
public class FurUsage extends Model {
    @Id
    public Integer id;
    public Fur fur;
    public Integer amount;
}
