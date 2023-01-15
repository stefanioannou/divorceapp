package gr.hua.dit.springbootdemo.dao;

import gr.hua.dit.springbootdemo.entity.Notary;

import java.util.List;

public interface NotaryDAO {

    public List<Notary> findAll();
    public void save(Notary notary);

    public Notary findById(int id);

}
