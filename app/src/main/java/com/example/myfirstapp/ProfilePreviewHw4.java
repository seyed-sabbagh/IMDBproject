package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfilePreviewHw4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preview_hw4);

        TextView txtName=findViewById(R.id.txtName);
        TextView txtFamily=findViewById(R.id.txtFamily);
        TextView txtAge=findViewById(R.id.txtAge);
        TextView txtEmail=findViewById(R.id.txtEmail);



        Button btnSaveProfile=findViewById(R.id.btnSaveProfile);
        Button btnEditProfil=findViewById(R.id.btnEditProfile);

        Intent i= getIntent();
        final String fname=i.getStringExtra("fname");
        final String lname=i.getStringExtra("lname");
        final String age=i.getStringExtra("age");
        final String email=i.getStringExtra("email");
        txtName.setText(fname);
        txtFamily.setText(lname);
        txtAge.setText(age);
        txtEmail.setText(email);
        //setResult(Activity.RESULT_OK,i);

        btnEditProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2=new Intent();
                i2.putExtra("fname",fname);
                i2.putExtra("lname", lname);
                i2.putExtra("age",age);
                i2.putExtra("email",email);
                i2.putExtra("result","Profile info saved successfully");

                setResult(Activity.RESULT_OK,i2);
                finish();



            }
        });

    }
}
