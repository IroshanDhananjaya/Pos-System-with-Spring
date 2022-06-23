package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(OrderDetails_PK.class)
public class OrderDetails {

    @Id
    private String oid;
    @Id
    private String itemCode;
    private double price;
    private int qty;
    private double total;
    @ManyToOne
    @JoinColumn(name="oId",referencedColumnName = "orderID",insertable = false,updatable = false)
    private Orders order;
    @ManyToOne
    @JoinColumn(name="itemCode",referencedColumnName = "itemCode",insertable = false,updatable = false)
    private Item item;

}
