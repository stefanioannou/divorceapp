package gr.hua.dit.springbootdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lawyer")
public class Lawyer {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="afm")
    private int afm;


    public Lawyer() {
    }


    public Lawyer(String firstName, String lastName, int afm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.afm = afm;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getAfm() {
        return afm;
    }


    public void setAfm(int afm) {
        this.afm = afm;
    }


    @Override
    public String toString() {
        return "Lawyer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", afm=" + afm + "]";
    }

}
