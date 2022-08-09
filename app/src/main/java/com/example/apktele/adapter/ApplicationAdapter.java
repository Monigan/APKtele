package com.example.apktele.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apktele.R;
import com.example.apktele.activity.ApplicationActivity;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.fragments.MainFragment;
import com.example.apktele.model.Application;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder> {

    Context context;
    Fragment fragment;
    List<Application> applicationList;

    ApplicationController applicationController;

    public ApplicationAdapter(Context context, Fragment fragment, List<Application> applicationList) {
        this.context = context;
        this.fragment = fragment;
        this.applicationList = applicationList;
    }

    @NonNull
    @Override
    public ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View applicationItems = LayoutInflater.from(context).inflate(R.layout.application_item, parent, false);
        return new ApplicationAdapter.ApplicationViewHolder(applicationItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.applicationTitle.setText(applicationList.get(position).getTitle());
        applicationController = new ApplicationController();
        int icoId = context.getResources().getIdentifier("ico_" + applicationList.get(position).getIco(), "drawable", context.getPackageName());

        Glide.with(context)
                .load(applicationList.get(position).getIco())
                .placeholder(icoId)
                .into(holder.applicationIco);
        holder.itemView.setOnClickListener(view -> {

            Application application = applicationController.getApplicationById(applicationList.get(position).getId());

            Bundle bundle = new Bundle();
            bundle.putLong("applicationId", application.getId());
            bundle.putString("applicationTitle", application.getTitle());
            bundle.putInt("applicationIco", icoId);
            bundle.putString("applicationIcoUrl", applicationList.get(position).getIco());
            bundle.putString("applicationFullDescription", application.getFullDescription());
            bundle.putString("applicationShortDescription", application.getShortDescription());
            bundle.putString("applicationTag", application.getApplicationTag());
            bundle.putInt("applicationMainCategory", application.getMainCategory());

            bundle.putString("descriptionRating", application.getDescriptionRating());
            bundle.putString("descriptionAuthor", application.getDescriptionAuthor());
            bundle.putString("descriptionSize", application.getDescriptionSize());
            bundle.putString("descriptionMPAA", application.getDescriptionMPAA());

            NavHostFragment.findNavController(fragment)
                    .navigate(R.id.action_MainFragment_to_ApplicationFragment, bundle);


//
//            Intent intent = new Intent(context, ApplicationActivity.class);
//            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
//                    (Activity) context,
//                    new Pair<>(holder.applicationIco, "applicationIcoTransition"));
//
//            intent.putExtra("applicationId", application.getId());
//            intent.putExtra("applicationTitle", application.getTitle());
//            intent.putExtra("applicationIco", icoId);
//            intent.putExtra("applicationIcoUrl", applicationList.get(position).getIco());
//            intent.putExtra("applicationFullDescription", application.getFullDescription());
//            intent.putExtra("applicationShortDescription", application.getShortDescription());
//            intent.putExtra("applicationTag", application.getApplicationTag());
//            intent.putExtra("applicationMainCategory", application.getMainCategory());
//
//            intent.putExtra("descrRating", application.getDescriptionRating());
//            intent.putExtra("descrAuthor", application.getDescriptionAuthor());
//            intent.putExtra("descrSize", application.getDescriptionSize());
//            intent.putExtra("descrMPAA", application.getDescriptionMPAA());
//
//            context.startActivity(intent, activityOptions.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return applicationList.size();
    }

    public static final class ApplicationViewHolder extends RecyclerView.ViewHolder {

        TextView applicationTitle, applicationDescription, applicationTag;
        ImageView applicationIco;

        public ApplicationViewHolder(@NonNull View itemView) {
            super(itemView);
            applicationTitle = itemView.findViewById(R.id.applicationTitle);
            applicationIco = itemView.findViewById(R.id.applicationIco);
            applicationDescription = itemView.findViewById(R.id.applicationFullDescription);
            applicationTag = itemView.findViewById(R.id.applicationTag);
        }
    }

}
