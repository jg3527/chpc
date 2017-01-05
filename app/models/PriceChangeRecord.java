package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class PriceChangeRecord extends Model{
    @Id
    public Integer id;
    public Clothes clothes;
    public Date date;
    public Double prevPrice;
    public Double curPrice;
}
