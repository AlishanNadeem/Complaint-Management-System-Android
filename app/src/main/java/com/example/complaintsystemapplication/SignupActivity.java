package com.example.complaintsystemapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    Button btnRegiserUser;
    EditText etCnumber,etName,etEmail,etPassowrd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();

        mAuth = FirebaseAuth.getInstance();

        etCnumber = findViewById(R.id.etCnumber);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassowrd = findViewById(R.id.etPassword);

        btnRegiserUser = findViewById(R.id.btnRegisterUser);

        btnRegiserUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number, name, email, password;
                name = etName.getText().toString();
                number = etCnumber.getText().toString();
                email = etEmail.getText().toString();
                password = etPassowrd.getText().toString();

                if (name.length() == 0)
                {
                    etName.requestFocus();
                    etName.setError("Enter a Valid name");
                }


                else if (number.length() == 0 )
                {
                    etCnumber.requestFocus();
                    etCnumber.setError("Number cannot be empty");
                }

                else if (email.length() == 0)
                {
                    etEmail.requestFocus();
                    etEmail.setError("Email cannot be empty");
                }

                else if (password.length() == 0)
                {
                    etPassowrd.requestFocus();
                    etPassowrd.setError("Password cannot be empty");
                }

                else {
//                    DatabaseReference mDatabase = database.getReference("users");
//                    Users user = new Users(name, number, email, password);
//                    mDatabase.child(email).setValue(user);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("users");

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(SignupActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                                private void updateUI(FirebaseUser user) {
                                    Intent userDashboardIntent = new Intent(SignupActivity.this, UserDashboardActivity.class);
                                    userDashboardIntent.putExtra("userEmail", user.getEmail());
                                    startActivity(userDashboardIntent);
                                    Users newUser = new Users(name, number, email, password);
                                    myRef.child(user.getEmail()).setValue(newUser);
                                }
                            });
                }

            }
        });

    }
}