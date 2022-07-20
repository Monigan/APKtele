package com.example.apktele.controller;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import com.example.apktele.dto.AplicationDTO;
import com.example.apktele.model.Application;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApplicationController {

    private int id = 0;
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String tag;
    private int category = 1;

    private String downloadPath;

    private String result;

    List<Application> applicationList = new ArrayList<>();


    public ApplicationController() {
    }

    public List<Application> getData() {
        try {
            //TODO Написать логику обработки JSON и заполнения данных о приложениях
            URL url = new URL("http://10.0.2.2:8091/applications");
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            new OkHttpClient().newCall(request)
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(final Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull final Response response) throws IOException {
                            result = Objects.requireNonNull(response.body()).string();
                            Log.i("HTTP_RESPOND", result);
                            Gson gson = new Gson();
                            Type listType = new TypeToken<ArrayList<AplicationDTO>>(){}.getType();
                            List<AplicationDTO> applicationDTOList = gson.fromJson(result, listType);
                            Log.i("LIST_APPLICATIONS_DTO", String.valueOf(applicationDTOList));
                            setDate(applicationDTOList);
                        }
                    });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return applicationList;
    }


    private void setDate(List<AplicationDTO> list) {
        for (int i = 0; i < list.size(); i++){
            applicationList.add(new Application(Math.toIntExact(list.get(i).getId()), list.get(i).getName(),"tmp",list.get(i).getDescription(),
                    "Join the endless running fun!", "Arcade", 2));
        }
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }
}
