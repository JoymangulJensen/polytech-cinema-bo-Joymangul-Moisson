package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Category;
import com.polytech.cinema.cinemaservices.model.Characters;
import com.polytech.cinema.cinemaservices.model.Director;
import com.polytech.cinema.cinemaservices.model.Film;
import com.polytech.cinema.cinemaservices.repo.CategoryRepository;
import com.polytech.cinema.cinemaservices.repo.CharactersRepository;
import com.polytech.cinema.cinemaservices.repo.DirectorRepository;
import com.polytech.cinema.cinemaservices.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/20/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    CharactersRepository charactersRepository;

    // Get All Films
    @GetMapping("")
    public List<Film> getAll() {
        return filmRepository.findAll();
    }


    //  Get one Film
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") int filmId) {
        Film film = filmRepository.findOne(filmId);
        if(film == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(film);
    }

    // Get all films directed by a specific director
    @GetMapping("/director/{id}")
    public ResponseEntity<Object> getFByDirector(@PathVariable(value = "id") int directorId) {
        // Find the corresponding director
        Director director = directorRepository.findOne(directorId);
        if(director == null)
            return ResponseEntity.notFound().build();

        List<Film> films = filmRepository.findByDirector(director);
        return ResponseEntity.ok().body(films);
    }

    // Get All films of a specific category
    @GetMapping("/category/{code}")
    public ResponseEntity<Object> getByCategory(@PathVariable(value = "code") String codeCategory) {
        // Find the corresponding category
        Category category = categoryRepository.findOne(codeCategory);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }

        List<Film> films = filmRepository.findByCategory(category);
        return ResponseEntity.ok().body(films);
    }


    // Create a new Film
    @PostMapping("")
    public Film create(@Valid Film film) {
        return filmRepository.save(film);
    }

    // Update a Film
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") int filmId,
                                             @Valid  Film FilmDetails) {
        Film film = filmRepository.findOne(filmId);
        if(film == null) {
            return ResponseEntity.notFound().build();
        }
        film.setBudget(FilmDetails.getBudget());
        film.setDuration(FilmDetails.getDuration());
        film.setGrossing(FilmDetails.getGrossing());
        film.setReleaseDate(FilmDetails.getReleaseDate());
        film.setTitle(FilmDetails.getTitle());
        film.setDirector(FilmDetails.getDirector());
        film.setCategory(FilmDetails.getCategory());

        Film updatedFilm = filmRepository.save(film);
        return ResponseEntity.ok(updatedFilm);
    }


    // Delete a Film
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int filmId) {
        Film film = filmRepository.findOne(filmId);
        if(film == null) {
            return ResponseEntity.notFound().build();
        }
        
        //Delete all characters that played in this movie
        List<Characters> characters = charactersRepository.findByIdFilm(filmId);
        charactersRepository.delete(characters);

        filmRepository.delete(film);
        return ResponseEntity.ok("OK");
    }
}
