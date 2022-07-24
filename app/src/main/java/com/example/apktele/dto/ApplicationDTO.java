package com.example.apktele.dto;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ApplicationDTO {
    public Long id;
    public String name;
    public String icon_path_file;
    public String path_file;
    public String fullDescription;
    public String shortDescription;
    public String rating;
    public ArrayList<String> screenshots;
    public ArrayList<String> reviews;
    public ArrayList<String> categories;

    String descrSize;
    String descrAuthor;
    String descrMPAA;

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

    public String getIcon_path_file() {
        return icon_path_file;
    }

    public void setIcon_path_file(String icon_path_file) {
        this.icon_path_file = icon_path_file;
    }

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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

    public String getDescrSize() {
        return descrSize;
    }

    public void setDescrSize(String descrSize) {
        this.descrSize = descrSize;
    }

    public String getDescrAuthor() {
        return descrAuthor;
    }

    public void setDescrAuthor(String descrAuthor) {
        this.descrAuthor = descrAuthor;
    }

    public String getDescrMPAA() {
        return descrMPAA;
    }

    public void setDescrMPAA(String descrMPAA) {
        this.descrMPAA = descrMPAA;
    }

    @NonNull
    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon_path_file='" + icon_path_file + '\'' +
                ", path_file='" + path_file + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", rating='" + rating + '\'' +
                ", screenshots=" + screenshots +
                ", reviews=" + reviews +
                ", categories=" + categories +
                ", descrSize='" + descrSize + '\'' +
                ", descrAuthor='" + descrAuthor + '\'' +
                ", descrMPAA='" + descrMPAA + '\'' +
                '}';
    }
}
