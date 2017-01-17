package models;

import com.avaje.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jingguo on 1/2/17.
 */
/*Orders sent to clothes factory*/
@Entity
public class ClothesOrder extends Model {
    @Id
    public Integer id;
    public Long date;
    public String factoryName;
    @OneToMany(cascade = CascadeType.ALL)
    public List<FurUsage> furList;
    public List<ClothesAmount> clothes;
    public boolean done;
    public String note;

}
