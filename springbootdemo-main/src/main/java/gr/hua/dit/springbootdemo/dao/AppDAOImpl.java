package gr.hua.dit.springbootdemo.dao;
import gr.hua.dit.springbootdemo.entity.App;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<App> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from App", App.class);
        List<App> apps = query.getResultList();
        return apps;
    }

    @Override
    @Transactional
    public void save(App app) {
        App aapp = entityManager.merge(app);
    }

    @Override
    @Transactional
    public App findById(int id) {
        return entityManager.find(App.class, id);
    }

    @Override
    @Transactional
    public void delete(int id){
        App app = entityManager.find(App.class,id);
        entityManager.remove(app);
    }
}
