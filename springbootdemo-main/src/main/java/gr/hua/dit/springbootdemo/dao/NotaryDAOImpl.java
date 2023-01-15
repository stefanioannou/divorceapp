package gr.hua.dit.springbootdemo.dao;

import gr.hua.dit.springbootdemo.entity.Notary;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class NotaryDAOImpl implements NotaryDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Notary> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Notary", Notary.class);
        List<Notary> notaries = query.getResultList();
        return notaries;
    }

    @Override
    public void save(Notary notary) {
        Notary anotary = entityManager.merge(notary);
    }

    @Override
    public Notary findById(int id) {
        return entityManager.find(Notary.class, id);
    }



}
