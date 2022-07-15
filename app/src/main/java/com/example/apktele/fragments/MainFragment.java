package com.example.apktele.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apktele.R;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainFragment extends Fragment {


    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;

    View view;



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Arcade", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_arcade)));
        categories.add(new Category(1, "Business", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_business)));
        categories.add(new Category(2, "Social", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_social)));
        categories.add(new Category(3, "Work", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_work)));
        categories.add(new Category(4, "Sport", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_sport)));
        categories.add(new Category(5, "Simulator", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_simulator)));
        categories.add(new Category(6, "Education", ContextCompat.getDrawable(inflater.getContext(), R.drawable.ic_cat_education)));

        setCategoryRecycler(categories);

        return view;
    }


    private void setCategoryRecycler(List<Category> categories) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.categoriesView);
        recyclerView.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(getContext(), categories);

        recyclerView.setAdapter(categoryAdapter);
    }
}