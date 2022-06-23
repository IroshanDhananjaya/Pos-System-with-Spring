package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.javafx.beans.IDProperty;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Orders {
    @Id
    private String orderID;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customerID", referencedColumnName = "id", nullable = false)
    private Customer customer;

    String date;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
}
