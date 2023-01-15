package gr.hua.dit.springbootdemo.controller;

import gr.hua.dit.springbootdemo.dao.AppDAO;
import gr.hua.dit.springbootdemo.entity.App;
import gr.hua.dit.springbootdemo.entity.App;
import gr.hua.dit.springbootdemo.entity.Customer;
import gr.hua.dit.springbootdemo.entity.Notary;
import gr.hua.dit.springbootdemo.service.NotaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppDAO appDAO;

    @Autowired
    private NotaryService notaryService;

    @GetMapping("")
    List<App> getall() {
        return appDAO.findAll();
    }

    @PostMapping("")
    App save(@RequestBody App app) {
        app.setId(0);
        appDAO.save(app);
        return app;
    }

    @GetMapping("/{id}")
    App get(@PathVariable int id) {
        App app = appDAO.findById(id);
        return app;
    }

    @PostMapping("/{aid}/notary")
    Notary addNotary(@PathVariable int aid, @RequestBody Notary notary) {
        int notaryId = notary.getId();
        App app = appDAO.findById(aid);

        if (app == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
        );
        }

        if(notaryId != 0){
            Notary anotary = notaryService.findNotary(notaryId);
            app.setNotary(anotary);
            notaryService.saveNotary(notary);
            return anotary;
        }
        app.setNotary(notary);
        notaryService.saveNotary(notary);
        return notary;

    }
}
