package gr.hua.dit.springbootdemo.service;

import gr.hua.dit.springbootdemo.entity.Notary;

import java.util.List;

public interface NotaryService {

    public List<Notary> getNotary();
    public void saveNotary(Notary notary);

    public Notary findNotary(int id);

}
