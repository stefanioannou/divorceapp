package gr.hua.dit.springbootdemo.dao;


import gr.hua.dit.springbootdemo.entity.Lawyer;

import java.util.List;

public interface LawyerDAO {

    public List<Lawyer> findAll();
    public void save(Lawyer lawyer);

    public Lawyer findById(int id);

}
