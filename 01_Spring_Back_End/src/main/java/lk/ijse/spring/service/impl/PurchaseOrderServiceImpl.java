package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    OrderDetailsRepo detailsRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void purchaseOrder(OrderDTO dto) {
        Orders orders = mapper.map(dto, Orders.class);

        if(!orderRepo.existsById(dto.getOrderID())){
            orderRepo.save(orders);
            if(dto.getOrderDetails().size()<1)throw new RuntimeException("No items added for the order..!");

            for(OrderDetails details:orders.getOrderDetails()){
                Item item = itemRepo.findById(details.getItemCode()).get();
                item.setQty(item.getQty()-details.getQty());
                itemRepo.save(item);
            }
        }else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOrderID() + " Already Exist.!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return mapper.map(orderRepo.findAll(), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public List<OrderDetailsDTO> getAllOrderDetails() {
        return mapper.map(detailsRepo.findAll(), new TypeToken<List<OrderDetailsDTO>>() {
        }.getType());
    }
}
