package com.cinema.tickets.dto;

import com.cinema.tickets.enums.MovieGenre;
import com.cinema.tickets.enums.Language;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by soniav on 10.1.2015 г..
 */
public class MovieDto {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private long id;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReleaseDateAsString(){
        return releaseDate!=null?dateFormat.format(releaseDate):"Unknown";
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}

