package gr.hua.dit.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="App")
public class App {
    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="lawyer_app",
            joinColumns=@JoinColumn(name="app_id"),
            inverseJoinColumns=@JoinColumn(name="lawyer_id"))
    private List<Lawyer> lawyers;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="notary_id")
    @JsonBackReference
    private Notary notary;

    // define constructors
    public App() {
    }
    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public Notary getNotary() {
        return notary;
    }

    public void setNotary(Notary notary) {
        this.notary = notary;
    }


    @Override
    public String toString() {
        return "app [id=" + id +"]";
    }

    public void addLawyer(Lawyer lawyer) {
        if (lawyers == null) {
            lawyers = new ArrayList<Lawyer>();
        }
        lawyers.add(lawyer);
    }




}
