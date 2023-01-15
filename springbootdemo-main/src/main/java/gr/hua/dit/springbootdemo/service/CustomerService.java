package gr.hua.dit.springbootdemo.service;
import gr.hua.dit.springbootdemo.entity.Customer;
import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    public Customer findCustomer(int id);

}
