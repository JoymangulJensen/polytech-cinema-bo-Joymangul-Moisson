package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Actor;
import com.polytech.cinema.cinemaservices.model.Category;
import com.polytech.cinema.cinemaservices.repo.ActeurRepository;
import com.polytech.cinema.cinemaservices.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
