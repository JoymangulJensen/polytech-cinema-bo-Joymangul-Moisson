package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Characters;
import com.polytech.cinema.cinemaservices.repo.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/9/2017.
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    // Get All Characters
    @GetMapping("")
    public List<Characters> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Get all characters for an actor
    @GetMapping("/actor/{id}")
    public ResponseEntity<List<Characters>> getCharacterByActor(@PathVariable(value = "id") int characterId) {
        List<Characters> character = characterRepository.findByIdActor(characterId);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

}
