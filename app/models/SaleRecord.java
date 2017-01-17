package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class SaleRecord extends Model {
    @Id
    public Integer id;
    @ManyToOne
    public Clothes clothes;
    public Double price;
    public Receipt receipt;
    public boolean returned;
}
