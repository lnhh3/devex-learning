package com.project.devexlearning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.devexlearning.R;
import com.project.devexlearning.entity.User;
import com.project.devexlearning.enums.Message;
import com.project.devexlearning.validation.Validator;

import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {
    private EditText registerName, registerEmail, registerUsername, registerPassword, registerConfirmPassword;
    private TextView loginRedirectTxt;
    private Button registerBtn;
    private String uuid, fullName, email, username, password, confirmPassword;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        registerBtn.setOnClickListener(v -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");

            uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fullName = registerName.getText().toString();
            email = registerEmail.getText().toString();
            username = registerUsername.getText().toString();
            password = registerPassword.getText().toString();
            confirmPassword = registerConfirmPassword.getText().toString();

            validatePassword();
        });

        loginRedirectTxt.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }

    private void validatePassword() {
        if (Validator.checkNullOrEmptyString(fullName)) registerName.setError(Message.FULL_NAME_CANNOT_EMPTY.getMessage());
        if (Validator.checkNullOrEmptyString(email)) registerEmail.setError(Message.EMAIL_CANNOT_EMPTY.getMessage());
        if (Validator.checkNullOrEmptyString(username)) registerUsername.setError(Message.USERNAME_CANNOT_EMPTY.getMessage());
        if (Validator.checkNullOrEmptyString(password)) registerPassword.setError(Message.PASSWORD_CANNOT_EMPTY.getMessage());
        if (Validator.checkNullOrEmptyString(confirmPassword)) registerConfirmPassword.setError(Message.CONFIRM_PASSWORD_CANNOT_EMPTY.getMessage());

        if (password.equals(confirmPassword) && Validator.checkNotNullAndNotEmptyString(confirmPassword)) {
            User user = new User(uuid, username, confirmPassword, email, fullName, null);
            reference.child(uuid).setValue(user);

            Toast.makeText(RegisterActivity.this, Message.REGISTER_SUCCESSFULLY.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        } else {
            registerConfirmPassword.setError(Message.CONFIRM_PASSWORD_NOT_MATCH.getMessage());
        }
    }

    private void initView() {
        registerName = findViewById(R.id.registerFullName);
        registerEmail = findViewById(R.id.registerEmail);
        registerUsername = findViewById(R.id.registerUsername);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        loginRedirectTxt = findViewById(R.id.loginRedirectTxt);
        registerBtn = findViewById(R.id.registerBtn);
    }
}