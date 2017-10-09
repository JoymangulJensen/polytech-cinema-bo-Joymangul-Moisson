package com.polytech.cinema.cinemaservices.Controller;

import com.polytech.cinema.cinemaservices.model.Actor;
import com.polytech.cinema.cinemaservices.repo.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/7/2017.
 */
@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    @Autowired
    ActeurRepository acteurRepository;

    // Get All Notes
    @GetMapping("")
    public List<Actor> getAllActeurs() {
        return acteurRepository.findAll();
    }
}
