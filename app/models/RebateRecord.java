package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class RebateRecord extends Model{
    @Id
    public Integer id;
    public Receipt soldRecord;
    public String name;
    public double amount;
}
