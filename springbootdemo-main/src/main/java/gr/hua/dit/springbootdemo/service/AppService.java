package gr.hua.dit.springbootdemo.service;
import gr.hua.dit.springbootdemo.entity.App;
import java.util.List;

public interface AppService {

    public List<App> getApp();
    public void saveApp(App app);

    public App findApp(int id);

    public void deleteApp(int id);
}
