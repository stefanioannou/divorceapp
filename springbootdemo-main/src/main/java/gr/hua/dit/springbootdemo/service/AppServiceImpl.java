package gr.hua.dit.springbootdemo.service;

import gr.hua.dit.springbootdemo.dao.AppDAO;

import gr.hua.dit.springbootdemo.entity.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppDAO appDAO;

    @Override
    @Transactional
    public List<App> getApp() {
        return appDAO.findAll();
    }

    @Override
    @Transactional
    public void saveApp(App app) {
        appDAO.save(app);
    }

    @Override
    @Transactional
    public App findApp(int id) {
      return  appDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteApp(int id) {
        appDAO.delete(id);
    }
}
