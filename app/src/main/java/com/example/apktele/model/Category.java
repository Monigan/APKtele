package com.example.apktele.model;

import android.graphics.drawable.Drawable;

public class Category {
    private Integer id;
    private final String title;
    private final Drawable ico;

    public Category(Integer id, String title, Drawable ico) {
        this.id = id;
        this.title = title;
        this.ico = ico;
    }

    public Drawable getIco() {
        return ico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

}
