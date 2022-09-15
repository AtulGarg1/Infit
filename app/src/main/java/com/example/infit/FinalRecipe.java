package com.example.infit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class FinalRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_recipe);

        TabLayout tabLayout;
        ViewPager viewPager;

        tabLayout = findViewById(R.id.final_recipe_tab_layout);
        viewPager = findViewById(R.id.final_recipe_view_pager);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new IngredientsFragment(), "Ingredients");
        viewPagerAdapter.addFragment(new RecipeDetailsFragment(), "Recipe Details");
        viewPager.setAdapter(viewPagerAdapter);
    }
}