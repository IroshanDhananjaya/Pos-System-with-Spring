package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.entity.OrderDetails;

import java.util.List;

public interface PurchaseOrderService {
    void purchaseOrder(OrderDTO dto);
    public List<OrderDTO> getAllOrders();
    public List<OrderDetailsDTO> getAllOrderDetails();
}
