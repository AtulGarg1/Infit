package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMessages extends RecyclerView.Adapter<AdapterMessages.ViewHolder>{
    Object[] dataSet;

    AdapterMessages(Object[] data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_messages_item, parent, false);
        return new AdapterMessages.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setup the values
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView patientImage;
        TextView patientName;
        ImageButton btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientImage = itemView.findViewById(R.id.recview_messages_profile);
            patientName = itemView.findViewById(R.id.recview_messages_name);
            btn = itemView.findViewById(R.id.recview_messages_btn);
        }
    }
}
