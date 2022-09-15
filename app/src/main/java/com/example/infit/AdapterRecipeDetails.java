package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecipeDetails extends RecyclerView.Adapter<AdapterRecipeDetails.ViewHolder> {

    Object[] dataSet;

    AdapterRecipeDetails(Object[] data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_recipe_details_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setup the views
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            details = itemView.findViewById(R.id.recview_recipe_details_text);
        }
    }
}
