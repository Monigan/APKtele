package com.example.apktele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.apktele.adapter.ApplicationAdapter;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.model.Application;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ImageButton mainButton, homeButton, backButton;
//    private SearchView searchField;
//    boolean isVisible = false;

    RecyclerView categoryView;
    RecyclerView applicationView;
    CategoryAdapter categoryAdapter;
    ApplicationAdapter applicationAdapter;

    ApplicationController applicationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCategoryRecycler(setTestCategory());
        setApplicationRecycler(setTestApplications());

//        mainButton = (ImageButton) findViewById(R.id.main_button);
//        homeButton = (ImageButton) findViewById(R.id.home_button);
//        backButton = (ImageButton) findViewById(R.id.back_button);
//
//        searchField = (SearchView) findViewById(R.id.app_search_field);
//
//
//        mainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isVisible){
//                    homeButton.setVisibility(View.INVISIBLE);
//                    backButton.setVisibility(View.INVISIBLE);
//                    searchField.setVisibility(View.INVISIBLE);
//                    isVisible = false;
//                }
//                else{
//                    homeButton.setVisibility(View.VISIBLE);
//                    backButton.setVisibility(View.VISIBLE);
//                    searchField.setVisibility(View.VISIBLE);
//                    isVisible = true;
//                }
//            }
//        });
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

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
        List<Application> applications = new ArrayList<>();
        applicationController = new ApplicationController();
        applications.add(new Application(0, "Subway Surfers","sb","The Subway Surfers World Tour is feeling the love in San Francisco. Team up with Super Runner Tricky, her Trickster Board, and Pride Miss Maia.\n" +
                "A Universal App with HD optimized graphics for retina resolution.", "Join the endless running fun!", "Arcade"));
        for (int i = 0; i<12; i++){
            applications.add(applicationController.getData());
        }
        return applications;
    }

    private List<Category> setTestCategory(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Arcade", ContextCompat.getDrawable(this, R.drawable.ic_cat_arcade)));
        categories.add(new Category(1, "Business", ContextCompat.getDrawable(this, R.drawable.ic_cat_business)));
        categories.add(new Category(2, "Social", ContextCompat.getDrawable(this, R.drawable.ic_cat_social)));
        categories.add(new Category(3, "Work", ContextCompat.getDrawable(this, R.drawable.ic_cat_work)));
        categories.add(new Category(4, "Sport", ContextCompat.getDrawable(this, R.drawable.ic_cat_sport)));
        categories.add(new Category(5, "Simulator", ContextCompat.getDrawable(this, R.drawable.ic_cat_simulator)));
        categories.add(new Category(6, "Education", ContextCompat.getDrawable(this, R.drawable.ic_cat_education)));

        return categories;
    }

}