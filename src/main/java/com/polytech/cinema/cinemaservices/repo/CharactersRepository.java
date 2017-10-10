package com.polytech.cinema.cinemaservices.repo;

import com.polytech.cinema.cinemaservices.model.Characters;
import com.polytech.cinema.cinemaservices.model.CharacterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/9/2017.
 */
@Repository
public interface CharacterRepository extends JpaRepository<Characters, CharacterPK> {

    List<Characters> findByIdActor(int id);
}
