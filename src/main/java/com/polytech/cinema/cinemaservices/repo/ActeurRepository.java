package com.polytech.cinema.cinemaservices.repo;

import com.polytech.cinema.cinemaservices.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/7/2017.
 */
@Repository
public interface ActeurRepository extends JpaRepository<Actor, Long> {
}
