package com.example.complaintsystemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etPassword, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;

                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                 if (email.length() == 0)
                {
                    etEmail.requestFocus();
                    etEmail.setError("Email cannot be empty");
                }
                else if (password.length() == 0)
                {
                    etPassword.requestFocus();
                    etPassword.setError("Password cannot be empty");
                }
                else {
                     Intent userDashboardIntent = new Intent(getApplicationContext(), UserDashboardActivity.class);
                     startActivity(userDashboardIntent);
                 }
            }
        });
    }
}