package gr.hua.dit.springbootdemo.controller;
import gr.hua.dit.springbootdemo.entity.Lawyer;
import gr.hua.dit.springbootdemo.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @GetMapping("")
    public List<Lawyer> getAll()
    {
        return lawyerService.getLawyers();
    }
}
