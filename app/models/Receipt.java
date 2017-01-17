package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by jingguo on 1/4/17.
 */
@Entity
public class Receipt extends Model {
    @Id
    public Integer id;
    List<SaleRecord> saleRecords;
    public Date date;
    public List<PaymentRecord> paymentRecords;
    /*回扣*/
    public List<RebateRecord> rebateRecords;
    public Double total;
    public boolean paid;
    public String note;
}
