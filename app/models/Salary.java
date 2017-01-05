package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/3/17.
 */
@Entity
public class Salary extends Model{
    @Id
    public Integer id;
    public Date startDate;
    public Date endDate;
    public Staff staff;
    public Double base;
    public Double bonus;
    public Double total;
}
