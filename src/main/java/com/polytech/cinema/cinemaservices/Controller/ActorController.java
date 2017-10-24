package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Actor;
import com.polytech.cinema.cinemaservices.model.Characters;
import com.polytech.cinema.cinemaservices.repo.ActorRepository;
import com.polytech.cinema.cinemaservices.repo.CharactersRepository;
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
@CrossOrigin
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CharactersRepository charactersRepository;

    // Get All Actors
    @GetMapping("")
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }


    //  Get one Actor
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getById(@PathVariable(value = "id") int actorId) {
        Actor actor = actorRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actor);
    }

    // Create a new Actor
    @PostMapping("")
    public Actor create(@Valid Actor actor) {
        return actorRepository.save(actor);
    }

    // Update an Actor
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") int actorId,
                                             @Valid  Actor actorDetails) {
        Actor actor = actorRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }
        actor.setName(actorDetails.getName());
        actor.setFirstName(actorDetails.getFirstName());
        actor.setBirthday(actorDetails.getBirthday());
        actor.setDeathDate(actorDetails.getDeathDate());

        Actor updatedActor = actorRepository.save(actor);
        return ResponseEntity.ok(updatedActor);
    }


    // Delete an actor
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int actorId) {
        Actor actor = actorRepository.findOne(actorId);
        if(actor == null) {
            return ResponseEntity.notFound().build();
        }

        //Delete all characters played by the actor
        List<Characters> characters = charactersRepository.findByIdActor(actorId);
        charactersRepository.delete(characters);

        actorRepository.delete(actor);
        return ResponseEntity.ok().build();
    }
}
