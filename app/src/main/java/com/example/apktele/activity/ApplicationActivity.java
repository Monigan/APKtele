package com.example.apktele.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apktele.MainActivity;
import com.example.apktele.R;

import java.util.Objects;


public class ApplicationActivity extends AppCompatActivity {

    TextView applicationTitle, applicationShortDescription, applicationFullDescription, applicationTag, descrRating, descrSize, descrAuthor, descrMPAA;
    ImageView applicationIco;
    RecyclerView applicationScreenshots;
    Button downloadButton;
    Button ratingButton;

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

        descrAuthor = findViewById(R.id.descrAuthorSet);
        descrSize = findViewById(R.id.descrSizeSet);
        descrRating = findViewById(R.id.descrRatingSet);
        descrMPAA = findViewById(R.id.descrMPAASet);

        downloadButton = findViewById(R.id.downloadButton);
        ratingButton = findViewById(R.id.ratingBtn);



        applicationTitle.setText(getIntent().getStringExtra("applicationTitle"));
        applicationFullDescription.setText(getIntent().getStringExtra("applicationFullDescription"));
        applicationShortDescription.setText(getIntent().getStringExtra("applicationShortDescription"));

        Glide.with(this)
                .load(getIntent().getStringExtra("applicationIcoUrl"))
                .placeholder(getIntent().getIntExtra("applicationIco", 0))
                .into(applicationIco);


        applicationTag.setText(getIntent().getStringExtra("applicationTag"));

        descrSize.setText(getIntent().getStringExtra("descrSize"));
        descrAuthor.setText(getIntent().getStringExtra("descrAuthor"));
        descrRating.setText(getIntent().getStringExtra("descrRating"));
        descrMPAA.setText(getIntent().getStringExtra("descrMPAA"));

        ratingButton.setOnClickListener(view -> Toast.makeText(ApplicationActivity.this, "Данная функция находится в разработке!", Toast.LENGTH_LONG).show());

    }

}