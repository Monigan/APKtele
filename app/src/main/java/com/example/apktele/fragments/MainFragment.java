package com.example.apktele.fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apktele.R;
import com.example.apktele.adapter.ApplicationAdapter;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.model.Application;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    RecyclerView categoryView;
    RecyclerView applicationView;
    CategoryAdapter categoryAdapter;
    ApplicationAdapter applicationAdapter;

    View view;



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment

        setCategoryRecycler(setTestCategory(inflater));
        setApplicationRecycler(setTestApplications(inflater));

        return view;
    }


    private void setCategoryRecycler(List<Category> categories) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        categoryView = view.findViewById(R.id.categoriesView);
        categoryView.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(getContext(), categories);

        categoryView.setAdapter(categoryAdapter);
    }

    private List<Category> setTestCategory(LayoutInflater inflater){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Arcade", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_arcade)));
        categories.add(new Category(1, "Business", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_business)));
        categories.add(new Category(2, "Social", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_social)));
        categories.add(new Category(3, "Work", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_work)));
        categories.add(new Category(4, "Sport", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_sport)));
        categories.add(new Category(5, "Simulator", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_simulator)));
        categories.add(new Category(6, "Education", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_education)));

        return categories;
    }
    private void setApplicationRecycler(List<Application> applications) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        applicationView = view.findViewById(R.id.applicationsView);
        applicationView.setLayoutManager(layoutManager);

        applicationAdapter = new ApplicationAdapter(getContext(), applications);

        applicationView.setAdapter(applicationAdapter);
    }

    private List<Application> setTestApplications(LayoutInflater inflater){
        List<Application> applications = new ArrayList<>();
        applications.add(new Application(0, "app1","decr1"));
        applications.add(new Application(1, "app2","decr1"));
        applications.add(new Application(2, "app3","decr1"));
        applications.add(new Application(3, "app4","decr1"));
        applications.add(new Application(4, "app5","decr1"));
        applications.add(new Application(5, "app6","decr1"));
        applications.add(new Application(6, "app7","decr1"));
        applications.add(new Application(7, "app8","decr1"));
        applications.add(new Application(8, "app9","decr1"));
        return applications;
    }
}