package com.example.apktele.dto;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ApplicationDTO {
    private Long id;
    private String name;
    private String icon_path_file;
    private String path_file;
    private String fullDescription;
    private String shortDescription;
    private String rating;
    private ArrayList<String> screenshots;
    private ArrayList<String> reviews;
    private ArrayList<String> categories;

    private String descriptionSize;
    private String descriptionAuthor;
    private String descriptionMPAA;

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


    public String getPath_file() {
        return path_file;
    }


    public String getShortDescription() {
        return shortDescription;
    }


    public String getFullDescription() {
        return fullDescription;
    }


    public String getRating() {
        return rating;
    }

    public ArrayList<String> getScreenshots() {
        return screenshots;
    }


    public ArrayList<String> getReviews() {
        return reviews;
    }


    public ArrayList<String> getCategories() {
        return categories;
    }


    public String getDescriptionSize() {
        return descriptionSize;
    }


    public String getDescriptionAuthor() {
        return descriptionAuthor;
    }


    public String getDescriptionMPAA() {
        return descriptionMPAA;
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
                ", descrSize='" + descriptionSize + '\'' +
                ", descrAuthor='" + descriptionAuthor + '\'' +
                ", descrMPAA='" + descriptionMPAA + '\'' +
                '}';
    }
}
