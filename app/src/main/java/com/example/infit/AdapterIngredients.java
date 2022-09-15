package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterIngredients extends RecyclerView.Adapter<AdapterIngredients.ViewHolder> {
    Object[] dataSet;

    AdapterIngredients(Object[] data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_ingredients_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setup the view
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ingredientImage;
        TextView ingredientName;
        TextView ingredientQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ingredientImage = itemView.findViewById(R.id.recview_ingredients_image);
            ingredientName = itemView.findViewById(R.id.recview_ingredients_name);
            ingredientQuantity = itemView.findViewById(R.id.recview_ingredients_quantity);
        }
    }
}
