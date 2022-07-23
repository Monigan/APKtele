package com.example.apktele.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apktele.R;
import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

public class AddApplicationPageActivity extends AppCompatActivity {
    Button btnActivity;
    //    категория, название, ico, полное описание, краткое описание, ярлык приложения
    TextView category, title, ico, fullDescription, shortDescription, applicationTag;

    RelativeLayout root;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_application);
        btnActivity = findViewById(R.id.btnActivity);

        root = findViewById(R.id.main);

        category = findViewById(R.id.category);
        title = findViewById(R.id.title);
        ico = findViewById(R.id.ico);
        fullDescription = findViewById(R.id.fullDescription);
        shortDescription = findViewById(R.id.shortDescription);
        applicationTag = findViewById(R.id.applicationIco);
        showActivityWindow();


//        btnActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showActivityWindow();
//            }
//        });
    }

    public void showActivityWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Приложение");
        dialog.setMessage("Введите все параметры приложения");
        LayoutInflater inflater = LayoutInflater.from(this);
        View activity_app_application = inflater.inflate(R.layout.activity_app_application, null);
        dialog.setView(activity_app_application);

        final MaterialEditText category = findViewById(R.id.category);
        final MaterialEditText title = findViewById(R.id.title);
        final MaterialEditText ico = findViewById(R.id.ico);
        final MaterialEditText fullDescription = findViewById(R.id.fullDescription);
        final MaterialEditText shortDescription = findViewById(R.id.shortDescription);
        @SuppressLint("WrongViewCast") MaterialEditText applicationTag = findViewById(R.id.applicationIco);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(category.getText().toString())) {
                    Snackbar.make(root, "Add category", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(title.getText().toString())) {
                    Snackbar.make(root, "Add title", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(ico.getText().toString())) {
                    Snackbar.make(root, "Add ico", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(fullDescription.getText().toString())) {
                    Snackbar.make(root, "Add fullDescription", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(shortDescription.getText().toString())) {
                    Snackbar.make(root, "Add shortDescription", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(applicationTag.getText().toString())) {
                    Snackbar.make(root, "Add applicationTag", Snackbar.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        dialog.show();
    }
}
