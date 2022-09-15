package com.example.infit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ReferralCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral_code);

        RecyclerView referralCodeRecView;

        referralCodeRecView = findViewById(R.id.recview_referral_code);
        referralCodeRecView.setLayoutManager(new LinearLayoutManager(this));
//        referralCodeRecView.setAdapter(new AdapterReferralCode());
    }
}