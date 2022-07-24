package com.example.apktele.model;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private Long id;
    private Integer mainCategory = 1;
    private List<String> allCategory = Collections.singletonList("");
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String applicationTag;


    private String descrRating = "0.0";
    private String descrAuthor = "unknown";
    private String descrSize = "unknown";
    private String descrMPAA = "G";


    public Application() {
        this.ico = null;
    }

    public Application(Long id, String title, String ico, List<String> category) {
        this.id = id;
        this.title = title;
        if (ico != null) this.ico = ico;
        if (category != null){
            this.mainCategory = Integer.parseInt(category.get(0));
            this.allCategory = category;
        }
        this.applicationTag = setTagToCategory(this.mainCategory);
    }

    public Application(Long id, String title, String ico, String fullDescription, String shortDescription,
                       String descrRating, String descrAuthor, String descrSize, String descrMPAA, ArrayList<String> category) {
        this.id = id;
        this.title = title;
        if (ico != null) this.ico = ico;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.descrRating = descrRating;
        this.descrAuthor = descrAuthor;
        this.descrSize = descrSize;
        this.descrMPAA = descrMPAA;
        if (category != null){
            this.mainCategory = Integer.parseInt(category.get(0));
            this.allCategory = category;
        }
        this.applicationTag = setTagToCategory(this.mainCategory);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIco() {
        return ico;
    }


    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getApplicationTag() {
        return applicationTag;
    }

    public void setApplicationTag(String applicationTag) {
        this.applicationTag = applicationTag;
    }

    public Integer getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Integer mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<String> getAllCategory() {
        return allCategory;
    }

    public void setAllCategory(List<String> allCategory) {
        this.allCategory = allCategory;
    }

    private String setTagToCategory(int category) {
        switch (category) {
            case 1:
                return "Other";
            case 2:
                return "Arcade";
            case 3:
                return "Business";
            case 4:
                return "Social";
            case 5:
                return "Work";
            case 6:
                return "Sport";
            case 7:
                return "Simulator";
            case 8:
                return "Education";
            default:
                return "Untagged";
        }
    }

    private String setShortFullDescription(String fullDescription){
        Log.i("APPLICATION_DESCRIPTION: ", fullDescription);
        if (fullDescription.length() < 30) return fullDescription;
        else return fullDescription.substring(0, 60);
    }

    public String getDescrRating() {
        return descrRating;
    }

    public void setDescrRating(String descrRating) {
        this.descrRating = descrRating;
    }

    public String getDescrAuthor() {
        return descrAuthor;
    }

    public void setDescrAuthor(String descrAuthor) {
        this.descrAuthor = descrAuthor;
    }

    public String getDescrSize() {
        return descrSize;
    }

    public void setDescrSize(String descrSize) {
        this.descrSize = descrSize;
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
        return "Application{" +
                "id=" + id +
                ", mainCategory=" + mainCategory +
                ", allCategory=" + allCategory +
                ", title='" + title + '\'' +
                ", ico='" + ico + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", applicationTag='" + applicationTag + '\'' +
                ", descrRating='" + descrRating + '\'' +
                ", descrAuthor='" + descrAuthor + '\'' +
                ", descrSize='" + descrSize + '\'' +
                ", descrMPAA='" + descrMPAA + '\'' +
                '}';
    }
}
