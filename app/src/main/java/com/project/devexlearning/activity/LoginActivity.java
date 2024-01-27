package com.project.devexlearning.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.devexlearning.R;
import com.project.devexlearning.entity.GoogleUser;
import com.project.devexlearning.enums.Message;
import com.project.devexlearning.validation.Validator;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText loginUsername, loginPassword;
    private String username, password;
    private Button loginBtn;
    private TextView registerRedirectTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginBtn.setOnClickListener(v -> {
            validateEmpty();
            inspectUser();
        });

        registerRedirectTxt.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void inspectUser() {
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordFromDb = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDb, userPassword)) {
                        Toast.makeText(LoginActivity.this,
                                Message.LOGIN_SUCCESSFULLY.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, IntroActivity.class));
                    } else {
                        loginPassword.setError(Message.INVALID_PASSWORD.getMessage());
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError(Message.USER_NOT_EXISTED.getMessage());
                    loginPassword.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void validateEmpty() {
        username = loginUsername.getText().toString();
        password = loginPassword.getText().toString();
        if (Validator.checkEmptyString(username))
            loginUsername.setError(Message.USERNAME_CANNOT_EMPTY.getMessage());
        if (Validator.checkEmptyString(password))
            loginPassword.setError(Message.PASSWORD_CANNOT_EMPTY.getMessage());
    }

    private void initView() {
        FirebaseApp.initializeApp(this);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        registerRedirectTxt = findViewById(R.id.registerRedirectTxt);
    }
}