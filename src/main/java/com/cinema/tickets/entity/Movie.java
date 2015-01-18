package com.cinema.tickets.entity;

import com.cinema.tickets.enums.Language;
import com.cinema.tickets.enums.MovieGenre;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kmitov on 1/16/15.
 */

@Entity
@Table(name = "movies")
public class Movie {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private int duration;
    private Language language;
    private MovieGenre genre;
    private Date releaseDate;
    private float rating;
    private String actors;
    private String directors;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", unique = true, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "imageUrl", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="language", nullable = false)
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Column(name="releaseDate", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name="rating", nullable = false)
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Column(name="actors", nullable = false)
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Column(name="directors", nullable = false)
    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="genre", nullable = false)
    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}
