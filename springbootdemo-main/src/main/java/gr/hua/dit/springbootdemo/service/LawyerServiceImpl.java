package gr.hua.dit.springbootdemo.service;


import gr.hua.dit.springbootdemo.dao.LawyerDAO;

import gr.hua.dit.springbootdemo.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LawyerServiceImpl implements LawyerService {

    @Autowired
    private LawyerDAO lawyerDAO;

    @Override
    @Transactional
    public List<Lawyer> getLawyers() {
        return lawyerDAO.findAll();
    }

    @Override
    @Transactional
    public void saveLawyer(Lawyer lawyer) {
        lawyerDAO.save(lawyer);
    }

    @Override
    @Transactional
    public Lawyer findLawyer(int id) {
        return  lawyerDAO.findById(id);
    }

}
