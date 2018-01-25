package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Characters;
import com.polytech.cinema.cinemaservices.model.Film;
import com.polytech.cinema.cinemaservices.repo.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/9/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharactersRepository characterRepository;

    // Get All Characters
    @GetMapping("")
    public List<Characters> getAllCharacters() {
        return characterRepository.findAll();
    }

    @GetMapping("/search")
    public List<Characters> getLikeName(@RequestParam(name = "title") String searchName) {
        return characterRepository.findByNameContaining(searchName);
    }

    // Get one character
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCharacters(@PathVariable(value = "id") int id) {
        Characters character = characterRepository.findOne(id);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

    // Get all characters for an actor
    @GetMapping("/actor/{id}")
    public ResponseEntity<List<Characters>> getCharacterByActor(@PathVariable(value = "id") int actorId) {
        List<Characters> character = characterRepository.findByIdActor(actorId);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

    // Get all characters for a film
    @GetMapping("/film/{id}")
    public ResponseEntity<Object> getCharacterByFilm(@PathVariable(value = "id") int filmId) {
        List<Characters> character = characterRepository.findByIdFilm(filmId);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

    // Create a new Character
    @PostMapping("")
    public Characters createCharacter(@Valid Characters character) {
        return characterRepository.save(character);
    }

    // Update one character
    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") int id,
                                             @Valid Characters characterDetails) {
        Characters character = characterRepository.findOne(id);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }

        character.setIdActor(characterDetails.getIdActor());
        character.setIdFilm(characterDetails.getIdFilm());
        character.setName(characterDetails.getName());
        Characters updatedCharacter = characterRepository.save(character);
        return ResponseEntity.ok(updatedCharacter);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        Characters character = characterRepository.findOne(id);
        if(character == null) {
            return ResponseEntity.notFound().build();
        }
        characterRepository.delete(character);
        return ResponseEntity.ok("OK");
    }
}
