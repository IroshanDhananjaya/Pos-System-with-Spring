package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

/**
 * @author : Dhananjaya
 * @since : 0.0.1
 **/
public interface CustomerService {
    public void saveCustomer(CustomerDTO entity);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO entity);

    public CustomerDTO searchCustomer(String id);

    public List<CustomerDTO> getAllCustomer();
}
