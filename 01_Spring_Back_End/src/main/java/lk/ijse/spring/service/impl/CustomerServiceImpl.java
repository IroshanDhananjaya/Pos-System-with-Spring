package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Dhananjaya
 * @since : 0.0.1
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO entity) {
        if (!customerRepo.existsById(entity.getId())) {
            Customer customer = modelMapper.map(entity, Customer.class);
            customerRepo.save(customer);
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }

    }

    @Override
    public void deleteCustomer(String id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new RuntimeException("No such customer ! Try Again....!");
        }

    }

    @Override
    public void updateCustomer(CustomerDTO entity) {
        if (customerRepo.existsById(entity.getId())) {
            Customer customer = modelMapper.map(entity, Customer.class);
            customerRepo.save(customer);
        } else {
            throw new RuntimeException("Invalid Id Please Try Again..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {

        Customer customer = customerRepo.findById(id).get();
        //CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {


        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
