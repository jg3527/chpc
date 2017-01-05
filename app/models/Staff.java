package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jingguo on 1/2/17.
 */
@Entity
public class Staff extends Model{
    @Id
    public Integer id;
    public String name;
}

