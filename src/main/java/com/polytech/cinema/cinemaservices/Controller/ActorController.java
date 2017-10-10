package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Actor;
import com.polytech.cinema.cinemaservices.repo.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/7/2017.
 */
@RestController
@RequestMapping("/acteurs")
public class ActorController {
    @Autowired
    ActeurRepository acteurRepository;

    // Get All Actors
    @GetMapping("")
    public List<Actor> getAllActeurs() {
        return acteurRepository.findAll();
    }


    //  Get one Actor
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable(value = "id") int actorId) {
        Actor actor = acteurRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actor);
    }
}
