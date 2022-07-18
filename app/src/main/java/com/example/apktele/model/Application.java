package com.example.apktele.model;

import android.graphics.drawable.Drawable;

public class Application {
    private int id;
    private String title;
    private String ico = "sb";
    private String description;

    public Application(int id, String title, String ico, String description) {
        this.id = id;
        this.title = title;
        this.ico = ico;
        this.description = description;
    }

    public Application(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
