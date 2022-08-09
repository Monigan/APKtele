package com.example.apktele.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.apktele.R;
import com.example.apktele.databinding.FragmentApplicationBinding;

public class ApplicationFragment extends Fragment {

    private FragmentApplicationBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentApplicationBinding.inflate(inflater, container, false);

//        applicationTitle = findViewById(R.id.applicationTitle);
//        applicationFullDescription = findViewById(R.id.applicationFullDescription);
//        applicationShortDescription = findViewById(R.id.applicationShortDescription);
//        applicationTag = findViewById(R.id.applicationTag);
//        applicationIco = findViewById(R.id.applicationIco);
//        applicationScreenshots = findViewById(R.id.applicationScreenshots);
//
//        descrAuthor = findViewById(R.id.descrAuthorSet);
//        descrSize = findViewById(R.id.descrSizeSet);
//        descrRating = findViewById(R.id.descrRatingSet);
//        descrMPAA = findViewById(R.id.descrMPAASet);
//
//        downloadButton = findViewById(R.id.downloadButton);
//        ratingButton = findViewById(R.id.ratingBtn);

//        binding.applicationTitle.findViewById(R.id.applicationTitle);
//        binding.applicationFullDescription.findViewById(R.id.applicationFullDescription);
//        binding.applicationShortDescription.findViewById(R.id.applicationShortDescription);
//
//        binding.applicationTag.findViewById(R.id.applicationTag);
//        binding.applicationIco.findViewById(R.id.applicationIco);
//        binding.applicationScreenshots.findViewById(R.id.applicationScreenshots);
//
//        binding.descriptionAuthor.findViewById(R.id.descriptionAuthorSet);
//        binding.descriptionSize.findViewById(R.id.descriptionSizeSet);
//        binding.descriptionRating.findViewById(R.id.descriptionRatingSet);
//        binding.descriptionMPAA.findViewById(R.id.descriptionMPAASet);
//
//        binding.downloadButton.findViewById(R.id.downloadButton);
//        binding.ratingButton.findViewById(R.id.ratingButton);



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            binding.applicationTitle.setText(bundle.getString("applicationTitle"));
            binding.applicationFullDescription.setText(bundle.getString("applicationFullDescription"));
            binding.applicationShortDescription.setText(bundle.getString("applicationShortDescription"));

            Glide.with(this)
                    .load(bundle.getString("applicationIcoUrl"))
                    .placeholder(bundle.getInt("applicationIco", 0))
                    .into(binding.applicationIco);


            binding.applicationTag.setText(bundle.getString("applicationTag"));

            binding.descriptionSizeSet.setText(bundle.getString("descriptionSize"));
            binding.descriptionAuthorSet.setText(bundle.getString("descriptionAuthor"));
            binding.descriptionRatingSet.setText(bundle.getString("descriptionRating"));
            binding.descriptionMPAASet.setText(bundle.getString("descriptionMPAA"));
        }

        binding.downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("APPLICATION_DOWNLOAD", "start");
                Toast.makeText(getContext(), "Данная функция находится в разработке!", Toast.LENGTH_LONG).show();
            }
        });

        binding.ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Данная функция находится в разработке!", Toast.LENGTH_LONG).show();
            }
        });


//        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(ApplicationFragment.this)
//                        .navigate(R.id.action_ApplicationFragment_to_MainFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}