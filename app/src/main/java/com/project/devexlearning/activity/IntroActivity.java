package com.project.devexlearning.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.project.devexlearning.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageView startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(v -> {
            startActivity(new Intent(IntroActivity.this, MainActivity.class));
        });
    }
}