package gr.hua.dit.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotBlank(message="Please enter the first name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String firstName;


    @Column(name = "last_name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String lastName;

    @Column(name="afm", unique = true)
    @Email(message = "Please enter a valid AFM number")
    @Size(max = 9)
    private int afm;

    @ManyToOne (fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="app_customer",
            joinColumns=@JoinColumn(name="customer_id"),
            inverseJoinColumns=@JoinColumn(name="app_id"))
    private App app;

    public Customer() {
    }

    public Customer(String firstName, String lastName, int afm) {
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

    public App getApp(){return app;}

    public void setApp(App app){this.app = app;}

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", afm=" + afm
                + "]";
    }
}
