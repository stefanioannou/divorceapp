package gr.hua.dit.springbootdemo.service;

import gr.hua.dit.springbootdemo.dao.CustomerDAO;

import gr.hua.dit.springbootdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public Customer findCustomer(int id) {
        return  customerDAO.findById(id);
    }

}
