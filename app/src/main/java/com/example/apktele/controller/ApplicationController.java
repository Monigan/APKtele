package com.example.apktele.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.apktele.dto.ApplicationDTO;
import com.example.apktele.model.Application;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApplicationController {

    List<Application> applicationList = new ArrayList<>();
    Application application;
    private String result;


    public ApplicationController() {
    }

    public void getData() {
        try {
            //TODO Написать логику обработки JSON и заполнения данных о приложениях
            URL url = new URL("http://10.0.2.2:8091/applications");
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            new OkHttpClient().newCall(request)
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull final Call call, @NonNull IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull final Response response) throws IOException {
                            result = Objects.requireNonNull(response.body()).string();
                            Log.i("HTTP_RESPOND", result);
                            Gson gson = new Gson();
                            Type listType = new TypeToken<ArrayList<ApplicationDTO>>() {
                            }.getType();
                            List<ApplicationDTO> applicationDTOList = gson.fromJson(result, listType);
                            Log.i("LIST_APPLICATIONS_DTO", String.valueOf(applicationDTOList));
                            setDateList(applicationDTOList);

                        }
                    });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void getDataById(long id) {
        try {
            //TODO Написать логику обработки JSON и заполнения данных о приложениях
            URL url = new URL("http://10.0.2.2:8091/applications/search/" + id);
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            new OkHttpClient().newCall(request)
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull final Call call, @NonNull IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull final Response response) throws IOException {
                            result = Objects.requireNonNull(response.body()).string();
                            Log.i("HTTP_RESPOND", result);
                            Gson gson = new Gson();
                            Type objectType = new TypeToken<ApplicationDTO>() {
                            }.getType();
                            ApplicationDTO applicationDTO = gson.fromJson(result, objectType);
                            Log.i("LIST_APPLICATIONS_DTO", String.valueOf(applicationDTO));
                            setDate(applicationDTO);

                        }
                    });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setDate(ApplicationDTO applicationDTO) {
        application = new Application(applicationDTO.getId(), applicationDTO.getName(), "tmp", applicationDTO.getDescription(), "ShortDescription", 0);
    }

    private void setDateList(List<ApplicationDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            applicationList.add(new Application(list.get(i).getId(), list.get(i).getName(), "tmp", list.get(i).getDescription(),
                    "Join the endless running fun!", 0));
        }
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public Application getApplication() {
        return application;
    }
}
