package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/3/17.
 */
@Entity
public class CheckIn extends Model {
    @Id
    public Integer id;
    public Date date;
    public Staff staff;
    public Store store;
}
