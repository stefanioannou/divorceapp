package gr.hua.dit.springbootdemo.service;
import gr.hua.dit.springbootdemo.entity.Lawyer;
import java.util.List;

public interface LawyerService {

    public List<Lawyer> getLawyers();
    public void saveLawyer(Lawyer lawyer);
    public Lawyer findLawyer(int id);

}
