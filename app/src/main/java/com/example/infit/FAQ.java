package com.example.infit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

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