package com.polytech.cinema.cinemaservices.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/8/2017.
 */
public class CharacterPK implements Serializable {
    private int idFilm;
    private int idActor;

    @Column(name = "id_film")
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Column(name = "id_actor")
    @Id
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterPK that = (CharacterPK) o;

        if (idFilm != that.idFilm) return false;
        if (idActor != that.idActor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idActor;
        return result;
    }
}
