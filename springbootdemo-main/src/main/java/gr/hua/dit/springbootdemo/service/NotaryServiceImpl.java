package gr.hua.dit.springbootdemo.service;

import gr.hua.dit.springbootdemo.dao.NotaryDAO;

import gr.hua.dit.springbootdemo.entity.Notary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NotaryServiceImpl implements NotaryService {

    @Autowired
    private NotaryDAO notaryDAO;

    @Override
    @Transactional
    public List<Notary> getNotary() {
        return notaryDAO.findAll();
    }

    @Override
    @Transactional
    public void saveNotary(Notary notary) {
        notaryDAO.save(notary);
    }

    @Override
    @Transactional
    public Notary findNotary(int id) {
        return notaryDAO.findById(id);
    }

}
