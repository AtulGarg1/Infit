package com.example.infit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // hide the nav bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        /*    dashboard    */
        dashboard();

        /*    add client    */
//        addClient();

        /*    final recipe    */
//        finalRecipe();

        /*    referral code    */
//        referralCode();

        /*    faq    */
//        faq();
    }

    private void addClient() {
        ImageButton btnSelectPlan;
        ImageButton btnSelectDuration;
        ImageButton btnSave;
        RadioButton male;
        RadioButton female;

        btnSave = findViewById(R.id.save);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        btnSelectPlan = findViewById(R.id.selectPlan);
        btnSelectDuration = findViewById(R.id.selectDuration);

        btnSelectPlan.setOnClickListener(view -> showPlanDialogBox());
        btnSelectDuration.setOnClickListener(view -> showDurationDialogBox());

        // had to do it like this because both radio buttons are in separate card layouts
        male.setOnClickListener(view -> {
            female.setChecked(false);
        });
        female.setOnClickListener(view -> {
            male.setChecked(false);
        });

        btnSave.setOnClickListener(view -> {
            // submit form
        });
    }

    private void dashboard() {
        /*    reviews alert box    */
        View reviewsLayout = findViewById(R.id.dashboard_customer_reviews);
        reviewsLayout.setOnClickListener(view -> showReviewsDialogBox());

        /*    patient profile recycler view    */
        RecyclerView patientProfile;
        patientProfile = findViewById(R.id.recview_patient_profile);
        // patientProfile.setAdapter(new AdapterPatientProfile());
        patientProfile.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        /*    consultation recycler view    */
        RecyclerView consultation;
        consultation = findViewById(R.id.recview_consultation);
        // consultation.setAdapter(new AdapterConsultation());
        consultation.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        /*    messages recycler view    */
        RecyclerView messages;
        messages = findViewById(R.id.recview_messages);
        // messages.setAdapter(new AdapterMessages());
        messages.setLayoutManager(new LinearLayoutManager(this));

    }

    private void showReviewsDialogBox() {
        // inflating dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View ReviewView = getLayoutInflater().inflate(R.layout.customer_reviews, null);

        // hooks
        RatingBar ratingBar;
        ImageView profile;
        TextView name;
        TextView ratingText;
        TextView description;
        TextView viewMoreBtn;

        ratingBar = findViewById(R.id.customer_reviews_rating);
        profile = findViewById(R.id.customer_reviews_profile);
        name = findViewById(R.id.customer_reviews_name);
        ratingText = findViewById(R.id.customer_reviews_rating_text);
        description = findViewById(R.id.customer_reviews_description);
        viewMoreBtn = findViewById(R.id.customer_reviews_view_more);

        // showing dialog box
        dialogBuilder.setView(ReviewView);
        Dialog dialog = dialogBuilder.create();
        dialog.show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        dialog.getWindow().setLayout(960, 600);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void showPlanDialogBox() {
        // inflating dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View selectPlanView = getLayoutInflater().inflate(R.layout.select_plan, null);

        // hooks
        ImageButton done = selectPlanView.findViewById(R.id.done_plan);
        RadioButton musclePlan = selectPlanView.findViewById(R.id.musclePlan);
        RadioButton weightLossPlan = selectPlanView.findViewById(R.id.weightLossPlan);
        RadioButton day17DietPlan = selectPlanView.findViewById(R.id.day17DietPlan);
        RadioButton proteinDietPlan = selectPlanView.findViewById(R.id.proteinDietPlan);
        RadioButton dailyDietPlan = selectPlanView.findViewById(R.id.dailyDietPlan);
        RadioButton ketoDietPlan = selectPlanView.findViewById(R.id.ketoDietPlan);

        // showing dialog
        dialogBuilder.setView(selectPlanView);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        dialog.getWindow().setLayout(width/2, 680);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        done.setOnClickListener(view -> {
            // action with checked plans
            dialog.dismiss();
        });
    }

    private void showDurationDialogBox() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View selectDurationView = getLayoutInflater().inflate(R.layout.select_duration, null);

        // hooks
        ImageButton done = selectDurationView.findViewById(R.id.done_duration);
        RadioButton duration_2 = selectDurationView.findViewById(R.id.duration_2);
        RadioButton duration_6 = selectDurationView.findViewById(R.id.duration_6);
        RadioButton duration_8 = selectDurationView.findViewById(R.id.duration_8);
        RadioButton duration_10 = selectDurationView.findViewById(R.id.duration_10);
        RadioButton duration_12 = selectDurationView.findViewById(R.id.duration_12);
        RadioButton duration_18 = selectDurationView.findViewById(R.id.duration_18);

        dialogBuilder.setView(selectDurationView);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        dialog.getWindow().setLayout(width/2, 680);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        done.setOnClickListener(view -> {
            // action with checked plans
            dialog.dismiss();
        });
    }

    private void finalRecipe() {
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

    private void referralCode() {
        RecyclerView referralCodeRecView;

        referralCodeRecView = findViewById(R.id.recview_referral_code);
        referralCodeRecView.setLayoutManager(new LinearLayoutManager(this));
//        referralCodeRecView.setAdapter(new AdapterReferralCode());
    }

    private void faq() {
        ImageButton faqs = findViewById(R.id.faq_faqs);
        ImageButton email = findViewById(R.id.faq_email);

        faqs.setOnClickListener(view -> {
            // do some work
        });

        email.setOnClickListener(view -> {
            // do some work
        });
    }
}