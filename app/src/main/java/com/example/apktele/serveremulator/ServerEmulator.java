package com.example.apktele.serveremulator;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerEmulator {
    private final List<String> applicationList = new ArrayList<>();
    private boolean reachable = true;

    public ServerEmulator(){
        if (isReachable()){
            setApplicationList();
        }
        Log.i("APPLICATION_LIST", applicationList.toString());
    }


    public String getApplicationById(Long id){
        return applicationList.get(Math.toIntExact(id));
    }

    public List<String> getApplicationList() {
        return applicationList;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    public boolean isReachable() {
        return reachable;
    }

    private void setApplicationList(){
        applicationList.add("{\"id\": 0, \"name\": \"Subway Surfers\", \"icon_path_file\": \"sb\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 1, \"name\": \"VK\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 2, \"name\": \"Avito\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 3, \"name\": \"Сбер\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 4, \"name\": \"Minecraft\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 5, \"name\": \"hh.ru\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 6, \"name\": \"Yandex\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
        applicationList.add("{\"id\": 7, \"name\": \"Google Chrome\", \"icon_path_file\": \"tmp\", \"categories\": [2,4], \"fullDescription\": \"FullDescription\", \"shortDescription\": \"ShortDescription\", \"rating\": \"4.4\", \"descriptionAuthor\": \"Me\", \"descriptionSize\": \"342.3 MB\", \"descriptionMPAA\": \"0+\"}");
    }

}

