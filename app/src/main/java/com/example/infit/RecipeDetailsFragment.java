package com.example.infit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipeDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // for testing purpose
        Object[] a = new Object[10];

        RecyclerView recipeDetailsRecView;
        recipeDetailsRecView = view.findViewById(R.id.recview_recipe_details);
        recipeDetailsRecView.setAdapter(new AdapterRecipeDetails(a));
        recipeDetailsRecView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}