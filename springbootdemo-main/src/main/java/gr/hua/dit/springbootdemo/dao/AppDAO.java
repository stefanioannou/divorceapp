package gr.hua.dit.springbootdemo.dao;
import gr.hua.dit.springbootdemo.entity.App;

import java.util.List;

public interface AppDAO {

    public List<App> findAll();
    public void save(App app);
    public void delete(int id);
    public App findById(int id);
}
