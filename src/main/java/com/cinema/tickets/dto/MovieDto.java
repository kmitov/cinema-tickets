package com.cinema.tickets.dto;

import com.cinema.tickets.entity.Movie;

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
    }

    private String title;
    private String description;
    private String imageUrl;
    private int duration;

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
}
