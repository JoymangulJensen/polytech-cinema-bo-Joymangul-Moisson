package com.polytech.cinema.cinemaservices.Controller;


import com.polytech.cinema.cinemaservices.model.Category;
import com.polytech.cinema.cinemaservices.model.Film;
import com.polytech.cinema.cinemaservices.repo.CategoryRepository;
import com.polytech.cinema.cinemaservices.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FilmRepository filmRepository;


    // Get All Category
    @GetMapping("")
    public List<Category> getAllC() {
        return categoryRepository.findAll();
    }

    // Get a category
    @GetMapping("/{code}")
    public ResponseEntity<Category> getByCode(@PathVariable(value = "code") String code) {
        Category category = categoryRepository.findOne(code);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    // Create a new Category
    @PostMapping("")
    public Category create(@Valid Category category) {
        return categoryRepository.save(category);
    }

    // Update a category
    @PutMapping("/{code}")
    public ResponseEntity<Object> update(@PathVariable(value = "code") String code,
                                             @Valid  Category categoryDetails) {
        Category category = categoryRepository.findOne(code);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }
        category.setName(categoryDetails.getName());

        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }


    // Delete a category
    @DeleteMapping("{code}")
    public ResponseEntity<Object> delete(@PathVariable(value = "code") String code) {
        Category category = categoryRepository.findOne(code);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }
        // Set all films with the deleted category to null
        List<Film> films = filmRepository.findByCategory(category);
        for (Film film: films) {
            film.setCategory(null);
            filmRepository.save(film);
        }
        categoryRepository.delete(category);
        return ResponseEntity.ok("OK");
    }
}
