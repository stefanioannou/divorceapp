package gr.hua.dit.springbootdemo.controller;
import java.util.List;

import gr.hua.dit.springbootdemo.entity.App;
import gr.hua.dit.springbootdemo.entity.Customer;
import gr.hua.dit.springbootdemo.entity.Lawyer;
import gr.hua.dit.springbootdemo.service.AppService;
import gr.hua.dit.springbootdemo.service.CustomerService;
import gr.hua.dit.springbootdemo.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private CustomerService CustomerService;

    @Autowired
    private LawyerService LawyerService;

    @Autowired
    private AppService AppService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customerslist")
    public String showTeacherList(Model model) {
        List<Customer> customers = CustomerService.getCustomers();
        model.addAttribute("customer", customers);
        return "list-customers";

    }

    @GetMapping("/lawyerslist")
    public String showLawyersList(Model model) {
        List<Lawyer> lawyers = LawyerService.getLawyers();
        model.addAttribute("lawyers", lawyers);
        return "lawyers";
    }

    @GetMapping("/applist")
    public String showAppsList(Model model) {
        List<App> apps = AppService.getApp();
        model.addAttribute("apps", apps);
        return "list-app";
    }

    @GetMapping("/appform")
    public String showAppsForm(Model model) {
        List<App> apps = AppService.getApp();
        model.addAttribute("apps", apps);
        return "form-app";
    }
}

