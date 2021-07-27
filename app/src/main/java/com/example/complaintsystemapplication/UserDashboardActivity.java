package com.example.complaintsystemapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDashboardActivity extends AppCompatActivity {

    TextView tvName, tvNumber;
    Button btnRegisterComplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);
        btnRegisterComplain = findViewById(R.id.btnRegisterComplain);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference mDatabase = database.getReference("users");

        Intent getInfoFromSignupAcivity = getIntent();
        String userEmail = getInfoFromSignupAcivity.getStringExtra("userEmail");

        tvName.setText(userEmail);

//        mDatabase.child(userEmail).setValue(userEmail);

    }

}