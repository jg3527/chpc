package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class ReturnRecord extends Model {
    @Id
    public Integer id;
    @ManyToOne
    public Clothes clothes;
    @OneToOne
    public SaleRecord saleRecord;
    public Date date;
}
