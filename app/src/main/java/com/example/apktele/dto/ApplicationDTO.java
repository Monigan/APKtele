package com.example.apktele.dto;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ApplicationDTO {
    public Long id;
    public String name;
    public String path_file;
    public String description;
    public Double rating;
    public ArrayList<String> screenshots;
    public ArrayList<String> reviews;
    public ArrayList<String> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(ArrayList<String> screenshots) {
        this.screenshots = screenshots;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path_file='" + path_file + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", screenshots=" + screenshots +
                ", reviews=" + reviews +
                ", categories=" + categories +
                '}';
    }
}
