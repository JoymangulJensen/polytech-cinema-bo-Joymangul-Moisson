package com.polytech.cinema.cinemaservices.repo;

import com.polytech.cinema.cinemaservices.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
}
