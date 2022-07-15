package com.example.apktele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton mainButton, homeButton, backButton;
    private SearchView searchField;
    boolean isVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = (ImageButton) findViewById(R.id.main_button);
        homeButton = (ImageButton) findViewById(R.id.home_button);
        backButton = (ImageButton) findViewById(R.id.back_button);

        searchField = (SearchView) findViewById(R.id.app_search_field);


        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible){
                    homeButton.setVisibility(View.INVISIBLE);
                    backButton.setVisibility(View.INVISIBLE);
                    searchField.setVisibility(View.INVISIBLE);
                    isVisible = false;
                }
                else{
                    homeButton.setVisibility(View.VISIBLE);
                    backButton.setVisibility(View.VISIBLE);
                    searchField.setVisibility(View.VISIBLE);
                    isVisible = true;
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}