package com.example.infit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class AddClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_client);

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
}