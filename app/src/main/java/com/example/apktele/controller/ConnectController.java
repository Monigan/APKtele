package com.example.apktele.controller;

import android.util.Log;

import com.example.apktele.exception.CantConnectException;
import com.example.apktele.model.Application;
import com.example.apktele.serveremulator.ServerEmulator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnectController {

//    private URL url;
//    private String suffix;
//    private String urlSite = "http://apteka-core-java-school-2022.apps.okd.stage.digital.rt.ru";
//    private String urlStorage = "https://apteka-store-java-school-2022.apps.okd.stage.digital.rt.ru/files/image/";
    private ServerEmulator serverEmulator;
    private List<String> applicationList;

    ConnectController(){
        serverEmulator = new ServerEmulator();
        applicationList = new ArrayList<>();
    }

    public void getConnect(String url){
        try {
            if (!serverEmulator.isReachable()) throw new CantConnectException();
            Log.i("SERVER_IS_REACHABLE", String.valueOf(serverEmulator.isReachable()));
            applicationList.addAll(serverEmulator.getApplicationList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getApplicationById(long id){
        try {
            if (!serverEmulator.isReachable()) throw new CantConnectException();
            return serverEmulator.getApplicationById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getApplicationList(){
        return applicationList;
    }

}
