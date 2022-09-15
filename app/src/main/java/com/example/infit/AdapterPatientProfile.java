package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPatientProfile extends RecyclerView.Adapter<AdapterPatientProfile.ViewHolder> {
    Object[] dataSet;

    AdapterPatientProfile(Object[] data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_patient_profile_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // set the image in holder.patientImage
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView patientImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientImage = itemView.findViewById(R.id.recview_patient_profile_image);
        }
    }
}
