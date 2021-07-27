package com.example.complaintsystemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ComplaintFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] CType={"Social", "Private", "Security"};

    EditText etTitle, etDescription;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_form);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,CType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,description;
                title = etTitle.getText().toString();
                description = etDescription.getText().toString();

                if (title.length() == 0 )
                {
                    etTitle.requestFocus();
                    etTitle.setError("Title cannot be empty");

                }
                else if (description.length() == 0)
                {
                    etDescription.requestFocus();
                    etDescription.setError("Description cannot be empty");

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Complaint Filed Successfully", Toast.LENGTH_LONG).show();

//
                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), CType[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}