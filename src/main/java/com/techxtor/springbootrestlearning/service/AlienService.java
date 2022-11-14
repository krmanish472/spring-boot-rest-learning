package com.techxtor.springbootrestlearning.service;

import com.techxtor.springbootrestlearning.model.Alien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlienService {
    private List<Alien> alienList = new ArrayList<>(
            Arrays.asList(
                    new Alien(101, "Manish"),
                    new Alien(102, "Ayush")
            )
    );

    public List<Alien> getAliens(){
        return alienList;
    }

    public List<Alien> addAlein(Alien alien) {
        alienList.add(alien);
        return alienList;
    }
}
