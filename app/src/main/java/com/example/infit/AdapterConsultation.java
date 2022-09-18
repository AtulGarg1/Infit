package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterConsultation extends RecyclerView.Adapter<AdapterConsultation.ViewHolder> {
    Object[] dataSet;

    AdapterConsultation(Object[] data) {
        dataSet = data;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public AdapterConsultation.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_consultation_item_first, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_consultation_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterConsultation.ViewHolder holder, int position) {
        // set the values from dataSet
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView time;
        TextView date;
        TextView name;
        ImageButton joinCall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.recview_consultation_profile);
            time = itemView.findViewById(R.id.recview_consultation_time);
            date = itemView.findViewById(R.id.recview_consultation_date);
            name = itemView.findViewById(R.id.recview_consultation_name);
            joinCall = itemView.findViewById(R.id.recview_consultation_btn);
        }
    }
}
