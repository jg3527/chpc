package models;

import com.avaje.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jingguo on 1/3/17.
 *
 * Clothes for sale
 */
@Entity
public class Clothes extends Model {
    @Id
    public Integer id;
    public ClothesInfo clothesInfo;
    /*衣服编号*/
    public String number;
    public Boolean sold;
    /*最低售价*/
    public Double minPrice;
    public Double cost;
    /*卖出价*/
    public Double soldPrice;
    @OneToMany(cascade = CascadeType.ALL)
    public List<FurUsage> furUsages;
    /*Which factory produced this*/
    public ClothesFactory clothesFactory;
    /*If clothes has been returned, record it here*/
    public String note;
    public Double processingFee;
    public SaleRecord saleRecord;

    public static Model.Finder<String, Clothes> find = new Model.Finder<>(
            Clothes.class);

    public static Clothes getClothesById(Integer id){
        return find.byId(id.toString());
    }

}

