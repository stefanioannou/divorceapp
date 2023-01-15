package gr.hua.dit.springbootdemo.controller;

import gr.hua.dit.springbootdemo.dao.CustomerDAO;
import gr.hua.dit.springbootdemo.entity.App;
import gr.hua.dit.springbootdemo.entity.Customer;
import gr.hua.dit.springbootdemo.entity.Notary;
import gr.hua.dit.springbootdemo.service.AppService;
import gr.hua.dit.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AppService appService;
    @GetMapping("")
    List<Customer> getall() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    Customer get(@PathVariable int id) {
        Customer customer = customerService.findCustomer(id);
        return customer;
    }

    @PostMapping("/{cid}/app")
        App addApp(@PathVariable int cid, @RequestBody App app) {
        int appId = app.getId();
        Customer customer = customerDAO.findById(cid);

        if (appId != 0) {
            App aapp = appService.findApp(appId);
            customer.setApp(aapp);
            appService.saveApp(app);
            return aapp;
        }
        customer.setApp(app);
        appService.saveApp(app);
        return app;
    }
}
