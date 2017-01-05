package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class PaymentRecord extends Model{
    @Id
    public Integer id;
    public String type;
    public String info;
    public double amount;
    public Date date;
    public Receipt record;
}
