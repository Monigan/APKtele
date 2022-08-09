package com.example.apktele.model;

import android.util.Log;

import androidx.annotation.NonNull;

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


    private String descriptionRating = "0.0";
    private String descriptionAuthor = "unknown";
    private String descriptionSize = "unknown";
    private String descriptionMPAA = "G";


    public Application() {
        this.ico = null;
    }

    public Application(Long id, String title, String ico, List<String> category) {
        this.id = id;
        this.title = title;
        if (!ico.equals("https://apteka-store-java-school-2022.apps.okd.stage.digital.rt.ru/files/image/")) this.ico = ico;
        if (category != null){
            this.mainCategory = Integer.parseInt(category.get(0));
            this.allCategory = category;
        }
        this.applicationTag = setTagToCategory(this.mainCategory);
    }

    public Application(Long id, String title, String ico, List<String> category, String fullDescription, String shortDescription,
                       String descriptionRating, String descriptionAuthor, String descriptionSize, String descriptionMPAA) {
        this.id = id;
        this.title = title;
        if (ico != null) this.ico = ico;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.descriptionRating = descriptionRating;
        this.descriptionAuthor = descriptionAuthor;
        this.descriptionSize = descriptionSize;
        this.descriptionMPAA = descriptionMPAA;
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


    public String getIco() {
        return ico;
    }


    public String getFullDescription() {
        return fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }


    public String getApplicationTag() {
        return applicationTag;
    }


    public Integer getMainCategory() {
        return mainCategory;
    }


    public List<String> getAllCategory() {
        return allCategory;
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

    public String getDescriptionRating() {
        return descriptionRating;
    }


    public String getDescriptionAuthor() {
        return descriptionAuthor;
    }


    public String getDescriptionSize() {
        return descriptionSize;
    }


    public String getDescriptionMPAA() {
        return descriptionMPAA;
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
                ", descriptionRating='" + descriptionRating + '\'' +
                ", descriptionAuthor='" + descriptionAuthor + '\'' +
                ", descriptionSize='" + descriptionSize + '\'' +
                ", descriptionMPAA='" + descriptionMPAA + '\'' +
                '}';
    }
}
