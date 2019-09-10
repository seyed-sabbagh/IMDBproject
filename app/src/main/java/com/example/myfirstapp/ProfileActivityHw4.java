package com.example.myfirstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivityHw4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_hw4);

        Button btnpreview=findViewById(R.id.btnPreview);
        final EditText edtName=findViewById(R.id.edtName);
        final EditText edtFamily=findViewById(R.id.edtFamily);
        final EditText edtAge=findViewById(R.id.edtAge);
        final EditText edtEmail=findViewById(R.id.edtEmail);

        String existingName=PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).getString("fname","");
        String existingFamily=PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).getString("lname","");
        String existingAge=PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).getString("age","");
        String existingEmail=PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).getString("email","");

        edtName.setText(existingName);
        edtFamily.setText(existingFamily);
        edtAge.setText(existingAge);
        edtEmail.setText(existingEmail);


        btnpreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivityHw4.this,ProfilePreviewHw4.class);
                i.putExtra("fname",edtName.getText().toString());
                i.putExtra("lname",edtFamily.getText().toString());
                i.putExtra("age",edtAge.getText().toString());
                i.putExtra("email",edtEmail.getText().toString());
                startActivityForResult(i,4125);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==4125){
            Log.d("preference","request code is the same");
            if (resultCode== Activity.RESULT_OK){
                Log.d("preference","result code is ok");
                String result=data.getStringExtra("result");
                String fname=data.getStringExtra("fname");
                String lname=data.getStringExtra("lname");
                String age=data.getStringExtra("age");
                String email=data.getStringExtra("email");
                PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).edit().putString("fname",fname).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).edit().putString("lname", lname).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).edit().putString("age",age).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivityHw4.this).edit().putString("email",email).apply();
                Toast.makeText(ProfileActivityHw4.this,result,Toast.LENGTH_LONG).show();

            }
        }
    }
}
