package com.example.apktele.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apktele.R;
import com.example.apktele.activity.ApplicationActivity;
import com.example.apktele.model.Application;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>{

    Context context;
    List<Application> applicationList;

    ApplicationActivity applicationActivity;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ApplicationActivity.class);
                intent.putExtra("applicationId", applicationList.get(position).getId());
                intent.putExtra("applicationTitle", applicationList.get(position).getTitle());
                intent.putExtra("applicationIco", icoId);
                intent.putExtra("applicationFullDescription", applicationList.get(position).getFullDescription());
                intent.putExtra("applicationShortDescription", applicationList.get(position).getShortDescription());
                intent.putExtra("applicationTag", applicationList.get(position).getApplicationTag());
                applicationActivity = new ApplicationActivity();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return applicationList.size();
    }

    public static final class ApplicationViewHolder extends RecyclerView.ViewHolder{

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
