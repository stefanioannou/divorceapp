package gr.hua.dit.springbootdemo.dao;

import gr.hua.dit.springbootdemo.entity.Lawyer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class LawyerDAOImpl implements LawyerDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Lawyer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Lawyer", Lawyer.class);
        List<Lawyer> lawyers = query.getResultList();
        return lawyers;
    }

    @Override
    public void save(Lawyer lawyer) {
        Lawyer alawyer = entityManager.merge(lawyer);
    }

    @Override
    public Lawyer findById(int id) {
        return entityManager.find(Lawyer.class, id);
    }



}
