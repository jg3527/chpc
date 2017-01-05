package models;

import com.avaje.ebean.Model;
import scala.reflect.internal.Trees;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by jingguo on 1/3/17.
 */
@Entity
public class Clothes extends Model {
    @Id
    public Integer id;
    public String number;
    public String size;
    public String color;
    public Boolean sold;
    public Double price;
    public Double cost;
    public Double soldPrice;
    public List<SaleRecord> saleRecords;
    public List<ReturnRecord> returnRecords;
    public String note;


}

