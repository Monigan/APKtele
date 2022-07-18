package com.example.apktele.controller;

import com.example.apktele.model.Application;

public class ApplicationController {

    private int id = 0;
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String tag;

    private String downloadPath;


    boolean badRequest = false;

    public ApplicationController() {
        this.id += 1;
        this.title = "Application " + this.id;
        this.fullDescription = "Fulldescription";
        this.shortDescription = "Shortdescription";
    }

    public Application getData(){
        try {
            setDate();
        }finally {
            return new Application(id, title, ico, fullDescription, shortDescription, tag);
        }
    }

    private void setDate() {
        this.id += 1;
        this.title = "Application " + this.id;
        this.fullDescription = "Fulldescription";
        this.shortDescription = "Shortdescription";
        this.tag = "Common";
    }
}
