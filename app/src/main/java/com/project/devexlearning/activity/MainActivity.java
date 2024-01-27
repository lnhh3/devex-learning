package com.project.devexlearning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.project.devexlearning.R;
import com.project.devexlearning.validation.Validator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout developingBtn, designingBtn, aiMLBtn, exploreBtn, homeBtn, purseBtn, detailBtn, settingBtn;
    ImageView userImg;
    TextView welcomeUserTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        updateUI();

        developingBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CoursesActivity.class));
        });

        detailBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        });

        settingBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        });
    }

    private void updateUI () {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (Validator.checkNotNull(user)) {
            for (UserInfo profile : user.getProviderData()) {
                welcomeUserTxt.setText(String.format("Hi, %s", Objects.requireNonNull(profile).getDisplayName()));
                Glide.with(MainActivity.this)
                        .load(Objects.requireNonNull(profile.getPhotoUrl()).toString())
                        .transform(new RoundedCorners(100))
                        .into(userImg);
            }
        }
    }

    private void initView() {
        FirebaseApp.initializeApp(this);
        developingBtn = findViewById(R.id.developingConstraint);
        designingBtn = findViewById(R.id.aiMLConstraint);
        exploreBtn = findViewById(R.id.exploreConstraint);
        homeBtn = findViewById(R.id.homeBtn);
        purseBtn = findViewById(R.id.purseBtn);
        detailBtn = findViewById(R.id.detailBtn);
        settingBtn = findViewById(R.id.settingBtn);
        userImg = findViewById(R.id.userImg);
        welcomeUserTxt = findViewById(R.id.welcomeUserTxt);
    }
}