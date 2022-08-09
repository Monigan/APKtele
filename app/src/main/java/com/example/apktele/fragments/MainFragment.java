package com.example.apktele.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apktele.R;
import com.example.apktele.adapter.ApplicationAdapter;
import com.example.apktele.adapter.CategoryAdapter;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.controller.CategoryController;
import com.example.apktele.databinding.FragmentMainBinding;
import com.example.apktele.model.Application;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private static List<Application> applications = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    private static ApplicationAdapter applicationAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationController applicationController = new ApplicationController();

        applications = applicationController.getApplicationList();
        Log.i("APPLICATIONS", String.valueOf(applications));
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMainBinding.inflate(inflater, container, false);

        setCategoryRecycler(setCategory());
        setApplicationRecycler(applications);


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(MainFragment.this)
//                        .navigate(R.id.action_MainFragment_to_ApplicationFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setCategoryRecycler(List<Category> categories) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.categoriesView.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), categories);
        binding.categoriesView.setAdapter(categoryAdapter);

    }

    private void setApplicationRecycler(List<Application> applications) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.applicationsView.setLayoutManager(layoutManager);
        applicationAdapter = new ApplicationAdapter(getContext(), MainFragment.this, applications);
        binding.applicationsView.setAdapter(applicationAdapter);
    }


    private List<Category> setCategory() {
        CategoryController categoryController = new CategoryController(getContext());
        return new ArrayList<>(categoryController.getCategoryList());
    }
}