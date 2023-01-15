package gr.hua.dit.springbootdemo.dao;

import gr.hua.dit.springbootdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();
    public void save(Customer customer);

    public Customer findById(int id);

}
