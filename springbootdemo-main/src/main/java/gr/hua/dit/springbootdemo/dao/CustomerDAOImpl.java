package gr.hua.dit.springbootdemo.dao;

import gr.hua.dit.springbootdemo.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Customer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void save(Customer customer) {
        Customer acustomer = entityManager.merge(customer);
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }



}
