package com.cinema.tickets.dto;

import com.cinema.tickets.entity.Movie;

import java.util.Date;

/**
 * Created by soniav on 10.1.2015 г..
 */
public class MovieDto {

    private Movie movie;

    public MovieDto(Movie movie){
        title = movie.getTitle();
        description = movie.getDescription();
        imageUrl = movie.getImageUrl();
        duration = movie.getDuration();
        language = movie.getLanguage();
        releaseDate = movie.getReleaseDate();
        rating = movie.getRating();
        actors = movie.getActors();
        directors = movie.getDirectors();
    }

    private String title;
    private String description;
    private String imageUrl;
    private int duration;
    private String language;
    private Date releaseDate;
    private float rating;
    private String actors;
    private String directors;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }
}
