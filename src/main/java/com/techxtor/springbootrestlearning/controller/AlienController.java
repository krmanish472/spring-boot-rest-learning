package com.techxtor.springbootrestlearning.controller;

import com.techxtor.springbootrestlearning.model.Alien;
import com.techxtor.springbootrestlearning.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlienController {
    private AlienService alienService;

    @Autowired
    public void setAlienService(AlienService alienService) {
        this.alienService = alienService;
    }

    @GetMapping(path = "aliens", produces = {"application/json", "application/xml"})
    public List<Alien> listAliens() {
        return alienService.getAliens();
    }

    @PostMapping(path = "alien", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Alien> addAlien(@RequestBody Alien alien) {
        return alienService.addAlein(alien);
    }
}
