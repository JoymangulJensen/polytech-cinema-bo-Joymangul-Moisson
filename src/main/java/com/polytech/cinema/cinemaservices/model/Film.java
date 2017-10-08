package com.polytech.cinema.cinemaservices.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 10/8/2017.
 */
@Entity
public class Film {
    private int id;
    private Integer budget;
    private Integer duration;
    private Integer grossing;
    private Date releaseDate;
    private String title;
    private Director director;
    private Category category;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "budget")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "grossing")
    public Integer getGrossing() {
        return grossing;
    }

    public void setGrossing(Integer grossing) {
        this.grossing = grossing;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (budget != null ? !budget.equals(film.budget) : film.budget != null) return false;
        if (duration != null ? !duration.equals(film.duration) : film.duration != null) return false;
        if (grossing != null ? !grossing.equals(film.grossing) : film.grossing != null) return false;
        if (releaseDate != null ? !releaseDate.equals(film.releaseDate) : film.releaseDate != null) return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (grossing != null ? grossing.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_director", referencedColumnName = "id")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director directorByIdDirector) {
        this.director = directorByIdDirector;
    }

    @ManyToOne
    @JoinColumn(name = "code_category", referencedColumnName = "code")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryByCodeCategory) {
        this.category = categoryByCodeCategory;
    }
}
