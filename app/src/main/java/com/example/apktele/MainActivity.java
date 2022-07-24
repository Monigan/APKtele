package com.example.apktele;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apktele.adapter.ApplicationAdapter;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.controller.CategoryController;
import com.example.apktele.model.Application;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    static ApplicationAdapter applicationAdapter;
    static List<Application> applications = new ArrayList<>();
    static List<Application> applicationsSave = new ArrayList<>();
    RecyclerView categoryView;
    RecyclerView applicationView;
    CategoryAdapter categoryAdapter;
    CategoryController categoryController;
    ApplicationController applicationController;

    @SuppressLint("NotifyDataSetChanged")
    public static void showApplicationByCategory(Integer category) {
        applications.clear();
        applications.addAll(applicationsSave);
        Log.i("CATEGORY-1 ", String.valueOf(category));
        if (category != 0) {
            List<Application> filterApplications = new ArrayList<>();
            for (Application app : applications) {
                Log.i("CATEGORY-2 ", String.valueOf(app.getMainCategory()));
                if (Objects.equals(app.getMainCategory(), category)) {
                    filterApplications.add(app);
                }
            }
            applications.clear();
            applications.addAll(filterApplications);
        }
        applicationAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationController = new ApplicationController();
        applicationController.getData();
        applications = applicationController.getApplicationList();
        while (applications.isEmpty()) {
            //TODO заменить данный костыль чем-нибудь более функциональным
        }
        setContentView(R.layout.activity_main);
        setApplicationRecycler(applications);
        setCategoryRecycler(setCategory());
    }


    @Override
    protected void onStart() {
        super.onStart();
        applicationsSave.addAll(applications);

    }

    private void setCategoryRecycler(List<Category> categories) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryView = findViewById(R.id.categoriesView);
        categoryView.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categories);

        categoryView.setAdapter(categoryAdapter);
    }

    private void setApplicationRecycler(List<Application> applications) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        applicationView = findViewById(R.id.applicationsView);
        applicationView.setLayoutManager(layoutManager);

        applicationAdapter = new ApplicationAdapter(this, applications);

        applicationView.setAdapter(applicationAdapter);
    }


    private List<Category> setCategory() {
        categoryController = new CategoryController(this);
        return new ArrayList<>(categoryController.getCategoryList());
    }

}