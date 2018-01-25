package com.polytech.cinema.cinemaservices.repo;

import com.polytech.cinema.cinemaservices.model.Category;
import com.polytech.cinema.cinemaservices.model.Director;
import com.polytech.cinema.cinemaservices.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/20/2017.
 */
public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByCategory(Category category);
    List<Film> findByDirector(Director director);
    List<Film> findByTitleContaining(String title);
}
