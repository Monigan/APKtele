package com.example.apktele.adapter;

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
import com.example.apktele.fragments.ApplicationFragment;
import com.example.apktele.model.Application;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>{

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
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, int position) {
        int icoId = context.getResources().getIdentifier("ico_" + applicationList.get(position).getIco(), "drawable", context.getPackageName());
        holder.applicationTitle.setText(applicationList.get(position).getTitle());
        holder.applicationIco.setImageResource(icoId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ApplicationFragment.class);
                intent.putExtra("applicationId", applicationList.get(position).getId());
                intent.putExtra("applicationTitle", applicationList.get(position).getTitle());
                intent.putExtra("applicationIco", applicationList.get(position).getIco());
                intent.putExtra("applicationDescription", applicationList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return applicationList.size();
    }

    public static final class ApplicationViewHolder extends RecyclerView.ViewHolder{

        TextView applicationTitle, applicationDescription;
        ImageView applicationIco;
        public ApplicationViewHolder(@NonNull View itemView) {
            super(itemView);
            applicationTitle = itemView.findViewById(R.id.applicationTitle);
            applicationIco = itemView.findViewById(R.id.applicationIco);
            applicationDescription = itemView.findViewById(R.id.app_fulldescription);
        }
    }

}
