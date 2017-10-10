package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Actor;
import com.polytech.cinema.cinemaservices.repo.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/7/2017.
 */
@RestController
@RequestMapping("/actor")
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

    // Create a new Actor
    @PostMapping("")
    public Actor createActor(@Valid Actor actor) {
        return acteurRepository.save(actor);
    }

    // Update an Actor
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@PathVariable(value = "id") int actorId,
                                             @Valid  Actor actorDetails) {
        Actor actor = acteurRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }
        actor.setName(actorDetails.getName());
        actor.setFirstName(actorDetails.getFirstName());
        actor.setBirthday(actorDetails.getBirthday());
        actor.setDeathDate(actorDetails.getDeathDate());

        Actor updatedNote = acteurRepository.save(actor);
        return ResponseEntity.ok(updatedNote);
    }

    // Delete an Actor
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNote(@PathVariable(value = "id") int actorId) {
        Actor actor = acteurRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }
        acteurRepository.delete(actor);
        return ResponseEntity.ok().build();
    }
}
