package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialActivityHw4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_hw4);

        final EditText edtPhoneNum=findViewById(R.id.edtDial);
        Button btnDial=findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNum=edtPhoneNum.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNum));
                startActivity(intent);
            }
        });
    }
}
