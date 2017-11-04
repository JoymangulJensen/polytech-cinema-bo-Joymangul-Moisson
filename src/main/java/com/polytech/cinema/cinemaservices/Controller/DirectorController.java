package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Director;
import com.polytech.cinema.cinemaservices.model.Film;
import com.polytech.cinema.cinemaservices.repo.DirectorRepository;
import com.polytech.cinema.cinemaservices.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/16/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    FilmRepository filmRepository;

    // Get all Directors
    @GetMapping("")
    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    // Get a Director
    @GetMapping("/{id}")
    public ResponseEntity<Director> getById(@PathVariable(value = "id") int directorId) {
        Director director = directorRepository.findOne(directorId);
        if(director == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(director);
    }

    // Create a new Director
    @PostMapping("")
    public Director create(@Valid Director director) {
        return directorRepository.save(director);
    }

    // Update a Director
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") int directorId,
                                             @Valid Director directorDetails) {
        Director director = directorRepository.getOne(directorId);
        if(director == null) {
            return ResponseEntity.notFound().build();
        }
        director.setName(directorDetails.getName());
        director.setFirstName(directorDetails.getFirstName());

        Director updatedDirector = directorRepository.save(director);
        return ResponseEntity.ok(updatedDirector);
    }


    // Delete a direction
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int directorId) {
        Director director = directorRepository.findOne(directorId);
        if(director == null) {
            return ResponseEntity.notFound().build();
        }

        // Set all films with the deleted director to null
        List<Film> films = filmRepository.findByDirector(director);
        for (Film film: films) {
            film.setDirector(null);
            filmRepository.save(film);
        }

        directorRepository.delete(director);
        return ResponseEntity.ok("OK");
    }

}
