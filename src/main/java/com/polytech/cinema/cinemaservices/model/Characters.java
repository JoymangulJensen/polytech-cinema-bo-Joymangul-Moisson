package com.polytech.cinema.cinemaservices.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/8/2017.
 */
@Entity
@IdClass(CharacterPK.class)
public class Characters {
    private int idFilm;
    private int idActor;
    private String name;
    private Film film;
    private Actor actor;

    @Id
    @Column(name = "id_film")
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_actor")
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Characters character = (Characters) o;

        if (idFilm != character.idFilm) return false;
        if (idActor != character.idActor) return false;
        if (name != null ? !name.equals(character.name) : character.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idActor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film filmByIdFilm) {
        this.film = filmByIdFilm;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actorByIdActor) {
        this.actor = actorByIdActor;
    }
}
