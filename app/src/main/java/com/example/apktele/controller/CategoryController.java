package com.example.apktele.controller;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.apktele.R;
import com.example.apktele.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {

    List<Category> categoryList = new ArrayList<>();

    public CategoryController(Context context) {
        categoryList.add(new Category(2, "Arcade", ContextCompat.getDrawable(context, R.drawable.ic_cat_arcade)));
        categoryList.add(new Category(3, "Business", ContextCompat.getDrawable(context, R.drawable.ic_cat_business)));
        categoryList.add(new Category(4, "Social", ContextCompat.getDrawable(context, R.drawable.ic_cat_social)));
        categoryList.add(new Category(5, "Work", ContextCompat.getDrawable(context, R.drawable.ic_cat_work)));
        categoryList.add(new Category(6, "Sport", ContextCompat.getDrawable(context, R.drawable.ic_cat_sport)));
        categoryList.add(new Category(7, "Simulator", ContextCompat.getDrawable(context, R.drawable.ic_cat_simulator)));
        categoryList.add(new Category(8, "Education", ContextCompat.getDrawable(context, R.drawable.ic_cat_education)));
        categoryList.add(new Category(1, "Other", ContextCompat.getDrawable(context, R.drawable.ic_cat_bg)));
        categoryList.add(new Category(0, "All", ContextCompat.getDrawable(context, R.drawable.ic_cat_bg)));
    }

    public List<Category> getCategoryList(){
        return categoryList;
    }
}
