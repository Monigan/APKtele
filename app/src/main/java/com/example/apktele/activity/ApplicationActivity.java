package com.example.apktele.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apktele.R;


public class ApplicationActivity extends AppCompatActivity {

    TextView applicationTitle, applicationShortDescription, applicationFullDescription, applicationTag;
    ImageView applicationIco;
    RecyclerView applicationScreenshots;
    Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        applicationTitle = findViewById(R.id.applicationTitle);
        applicationFullDescription = findViewById(R.id.applicationFullDescription);
        applicationShortDescription = findViewById(R.id.applicationShortDescription);
        applicationTag = findViewById(R.id.applicationTag);
        applicationIco = findViewById(R.id.applicationIco);
        applicationScreenshots = findViewById(R.id.applicationScreenshots);
        downloadButton = findViewById(R.id.downloadButton);


        applicationTitle.setText(getIntent().getStringExtra("applicationTitle"));
        applicationFullDescription.setText(getIntent().getStringExtra("applicationFullDescription"));
        applicationShortDescription.setText(getIntent().getStringExtra("applicationShortDescription"));
        applicationIco.setImageResource(getIntent().getIntExtra("applicationIco", 0));
        applicationTag.setText(getIntent().getStringExtra("applicationTag"));



    }

}