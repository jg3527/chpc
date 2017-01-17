package models;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jingguo on 1/16/17.
 */
public class ClothesInfo {
    @Id
    public Integer id;
    public String size;
    public String color;
    public String style;
    public String note;


}
