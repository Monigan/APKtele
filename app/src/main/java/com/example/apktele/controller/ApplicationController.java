package com.example.apktele.controller;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import com.example.apktele.model.Application;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApplicationController {

    private int id = 0;
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String tag;
    private int category = 1;

    private String downloadPath;

    JSONObject jsonObject;

    boolean badRequest = false;

    public ApplicationController() {
        this.id += 1;
        this.title = "Application " + this.id;
        this.fullDescription = "Fulldescription";
        this.shortDescription = "Shortdescription";
    }

    public Application getData(){
        try {
//            URL url = new URL("https://");
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
//
//                setDate();
//            }
//            else {
//                throw new Exception();
//            }
            setDate();
        }finally {
            return new Application(id, title, ico, fullDescription, shortDescription, tag, category);
        }
    }

    private void setDate() {
        this.id += 1;
        this.title = "Application " + this.id;
        this.fullDescription = "Fulldescription";
        this.shortDescription = "Shortdescription";
        this.tag = "Common";
        this.category = 1;
    }

    public abstract class GetURLDate extends AsyncTaskLoader<String> {

        public GetURLDate(@NonNull Context context) {
            super(context);

        }
    }
}
