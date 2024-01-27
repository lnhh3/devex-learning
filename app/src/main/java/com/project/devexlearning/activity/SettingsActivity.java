package com.project.devexlearning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Mesh;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.project.devexlearning.R;
import com.project.devexlearning.enums.Message;

public class SettingsActivity extends AppCompatActivity {
    private ConstraintLayout backBtn;
    private RelativeLayout signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();

        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
        signOutBtn = findViewById(R.id.signOutBtn);
    }
}