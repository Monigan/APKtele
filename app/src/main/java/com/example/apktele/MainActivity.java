package com.example.apktele;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.apktele.adapter.ApplicationAdapter;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.controller.CategoryController;
import com.example.apktele.model.Application;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryView;
    RecyclerView applicationView;
    CategoryAdapter categoryAdapter;
    CategoryController categoryController;
    private boolean flag = true;

    @SuppressLint("StaticFieldLeak")
    static ApplicationAdapter applicationAdapter;
    static List<Application> applications = new ArrayList<>();
    static List<Application> applicationsSave = new ArrayList<>();


    ApplicationController applicationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationController = new ApplicationController();
        applicationController.getData();
        setContentView(R.layout.activity_main);

        setCategoryRecycler(setCategory());


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(flag){
            setApplicationRecycler(setTestApplications());
            flag = false;
        }

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

    private List<Application> setTestApplications(){
        applications.add(new Application(0L, "Subway Surfers","sb","The Subway Surfers World Tour is feeling the love in San Francisco. Team up with Super Runner Tricky, her Trickster Board, and Pride Miss Maia.\n" +
                "A Universal App with HD optimized graphics for retina resolution.", "Join the endless running fun!", 2));

//        if (applicationController.getData() != null) applications.addAll(applicationController.getData());


        applications.addAll(applicationController.getApplicationList());
        applicationsSave.addAll(applications);
        Log.i("App_add", String.valueOf(applicationController.getApplicationList()));
        return applications;
    }

    private List<Category> setCategory(){
        categoryController = new CategoryController(this);

//        categories.add(new Category(2, "Arcade", ContextCompat.getDrawable(this, R.drawable.ic_cat_arcade)));
//        categories.add(new Category(3, "Business", ContextCompat.getDrawable(this, R.drawable.ic_cat_business)));
//        categories.add(new Category(4, "Social", ContextCompat.getDrawable(this, R.drawable.ic_cat_social)));
//        categories.add(new Category(5, "Work", ContextCompat.getDrawable(this, R.drawable.ic_cat_work)));
//        categories.add(new Category(6, "Sport", ContextCompat.getDrawable(this, R.drawable.ic_cat_sport)));
//        categories.add(new Category(6, "Simulator", ContextCompat.getDrawable(this, R.drawable.ic_cat_simulator)));
//        categories.add(new Category(8, "Education", ContextCompat.getDrawable(this, R.drawable.ic_cat_education)));
//        categories.add(new Category(1, "Other", ContextCompat.getDrawable(this, R.drawable.ic_cat_bg)));
//        categories.add(new Category(0, "All", ContextCompat.getDrawable(this, R.drawable.ic_cat_bg)));

        List<Category> categoryList = new ArrayList<>();
        categoryList.addAll(categoryController.getCategoryList());
        return categoryList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showApplicationByCategory(int category){
        applications.clear();
        applications.addAll(applicationsSave);
        if (category != 0){
            List<Application> filterApplications = new ArrayList<>();
            for(Application app : applications){
                if(app.getCategory() == category){
                    filterApplications.add(app);
                }
            }
            applications.clear();
            applications.addAll(filterApplications);
        }
        applicationAdapter.notifyDataSetChanged();
    }

}