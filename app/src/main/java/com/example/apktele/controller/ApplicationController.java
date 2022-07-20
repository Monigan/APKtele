package com.example.apktele.controller;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import com.example.apktele.model.Application;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ConcurrentModificationException;

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

    JSONObject jsonObject;

    boolean badRequest = false;


    public ApplicationController() {
        this.id += 1;
        this.title = "Application " + this.id;
//        this.fullDescription = "Fulldescription";
        this.shortDescription = "Shortdescription";
    }

    public Application getData() {
        try {
            //TODO Написать логику обработки JSON и заполнения данных о приложениях
            URL url = new URL("https://10.0.2.2:8091/applications");
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
                        public void onResponse(Call call, final Response response) throws IOException {
                            String res = response.body().string();
                            setDate(res);
                        }
                    });

//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                connection.connect();
//                InputStream stream = connection.getInputStream();
//                reader = new BufferedReader(new InputStreamReader(stream));
//
//                StringBuffer buffer = new StringBuffer();
//                String line = "";
//
//                while ((line = reader.readLine()) != null)
//                    buffer.append(line).append("\n");
//                setDate(buffer.toString());
//                return new Application(id, title, ico, fullDescription, shortDescription, tag, category);
//            } else {
//                throw new NetworkErrorException();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NetworkErrorException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) connection.disconnect();
//            try {
//                if (reader != null) reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void setDate(String line) {
        this.id += 1;
        this.title = "Application " + this.id;
        this.fullDescription = line;
        this.shortDescription = "Shortdescription";
        this.tag = "Common";
        this.category = 1;
    }

    public String getFullDescription(){
        return fullDescription;
    }
}
