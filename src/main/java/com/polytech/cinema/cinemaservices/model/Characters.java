package com.polytech.cinema.cinemaservices.model;

import javax.persistence.*;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/8/2017.
 */
@Entity
public class Characters {
    private int idFilm;
    private int idActor;
    private int id;
    private String name;
    private Film film;
    private Actor actor;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_film")
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

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

        Characters that = (Characters) o;

        if (getIdFilm() != that.getIdFilm()) return false;
        if (getIdActor() != that.getIdActor()) return false;
        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getFilm() != null ? !getFilm().equals(that.getFilm()) : that.getFilm() != null) return false;
        return getActor() != null ? getActor().equals(that.getActor()) : that.getActor() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdFilm();
        result = 31 * result + getIdActor();
        result = 31 * result + getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getFilm() != null ? getFilm().hashCode() : 0);
        result = 31 * result + (getActor() != null ? getActor().hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_Film", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film filmByIdFilm) {
        this.film = filmByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "id_Actor", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actorByIdActor) {
        this.actor = actorByIdActor;
    }
}
