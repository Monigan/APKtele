package com.example.apktele.model;

import android.graphics.drawable.Drawable;

public class Application {
    private int id;
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String applicationTag;

    public Application(int id, String title, String ico, String fullDescription, String shortDescription) {
        this.id = id;
        this.title = title;
        this.ico = ico;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
    }

    public Application(int id, String title, String fullDescription, String shortDescription) {
        this.id = id;
        this.title = title;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
    }

    public Application(int id, String title, String ico, String fullDescription, String shortDescription, String applicationTag) {
        this.id = id;
        this.title = title;
        this.ico = ico;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.applicationTag = applicationTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setIco(String ico) {
        this.ico = ico;
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
}
