package com.polytech.cinema.cinemaservices.repo;

import com.polytech.cinema.cinemaservices.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/16/2017.
 */
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    List<Director> findByNameContaining(String name);
}
