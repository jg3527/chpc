package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by jingguo on 1/11/17.
 */
@Entity
public class FurOutput extends Model{
    @Id
    public Integer id;
    @ManyToOne
    List<ClothesFurUsage> furUsages;
    public Long date;
    public String factoryName;
    @ManyToOne
    public List<ClothesOrder> clothesOrders;
}
