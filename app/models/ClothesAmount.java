package models;

import javax.persistence.Id;

/**
 * Created by jingguo on 1/16/17.
 */
public class ClothesAmount {
    @Id
    public Long id;
    public ClothesInfo clothesInfo;
    public Integer amount;
}
