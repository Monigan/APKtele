package com.example.apktele.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apktele.R;

public class ApplicationFragment extends Fragment {

    TextView applicationTitle, applicationShortDescription, applicationFullDescription;
    ImageView applicationIco;
    Button downloadButton;


    public ApplicationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application, container, false);

        applicationTitle = view.findViewById(R.id.applicationTitle);
        applicationFullDescription = view.findViewById(R.id.app_fulldescription);
        applicationShortDescription = view.findViewById(R.id.app_shortdescription);
        applicationIco = view.findViewById(R.id.applicationIco);
        downloadButton = view.findViewById(R.id.downloadButton);

        return view;
    }
}