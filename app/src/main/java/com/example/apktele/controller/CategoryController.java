package com.example.apktele.controller;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.apktele.R;
import com.example.apktele.model.Category;

import java.util.List;

public class CategoryController {

    List<Category> categoryList;

    public CategoryController(Context context) {

    }

    public List<Category> getCategoryList(){
        return categoryList;
    }
}
