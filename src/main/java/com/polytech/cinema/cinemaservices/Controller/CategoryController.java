package com.polytech.cinema.cinemaservices.Controller;


import com.polytech.cinema.cinemaservices.model.Category;
import com.polytech.cinema.cinemaservices.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    // Get All Category
    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    // Get a category
    @GetMapping("/{code}")
    public ResponseEntity<Category> getCategoryByCode(@PathVariable(value = "code") String code) {
        Category category = categoryRepository.findOne(code);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    // Create a new Category
    @PostMapping("")
    public Category createActor(@Valid Category category) {
        return categoryRepository.save(category);
    }

    // Update a category
    @PutMapping("/{code}")
    public ResponseEntity<Object> updateNote(@PathVariable(value = "code") String code,
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
    public ResponseEntity<Object> deleteNote(@PathVariable(value = "code") String code) {
        Category category = categoryRepository.findOne(code);
        if(category == null) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }
}
