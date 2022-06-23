package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDTO {
    String orderID;
    CustomerDTO customer;
    @JsonFormat(pattern = "MM-dd-yyyy")
    String date;
    List<OrderDetailsDTO> orderDetails;
}
