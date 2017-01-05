package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jingguo on 1/2/17.
 */
/*Orders sent to clothes factory*/
@Entity
public class ClothesOrder extends Model {
    @Id
    public Integer id;
    public Date date;
    public String name;
    public Fur fur;
    public Double amount;
    public String note;
    public Double processingFee;

}
