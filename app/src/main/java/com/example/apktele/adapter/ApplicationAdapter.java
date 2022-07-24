package com.example.apktele.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apktele.R;
import com.example.apktele.activity.ApplicationActivity;
import com.example.apktele.controller.ApplicationController;
import com.example.apktele.model.Application;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder> {

    Context context;
    List<Application> applicationList;


    public ApplicationAdapter(Context context, List<Application> applicationList) {
        this.context = context;
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
        int icoId = context.getResources().getIdentifier("ico_" + applicationList.get(position).getIco(), "drawable", context.getPackageName());
        holder.applicationTitle.setText(applicationList.get(position).getTitle());
        holder.applicationIco.setImageResource(icoId);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ApplicationActivity.class);

            ApplicationController applicationController = new ApplicationController();
            applicationController.getDataById(applicationList.get(position).getId());
            Application application;
            while ((application = applicationController.getApplication()) == null){
                //TODO тоже самое что и в main-активити
            }

            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(holder.applicationIco, "applicationIcoTransition"));

            intent.putExtra("applicationId", application.getId());
            intent.putExtra("applicationTitle", application.getTitle());
            intent.putExtra("applicationIco", icoId);
            intent.putExtra("applicationFullDescription", application.getFullDescription());
            intent.putExtra("applicationShortDescription", application.getShortDescription());
            intent.putExtra("applicationTag", application.getApplicationTag());

            context.startActivity(intent, activityOptions.toBundle());
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
