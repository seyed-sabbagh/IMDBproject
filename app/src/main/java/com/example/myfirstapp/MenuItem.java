package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        final Button mnuItm=findViewById(R.id.btnMenuItem1);
        mnuItm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu","item is "+ mnuItm.getText());

                if (mnuItm.getText()=="Dial")
                {
                    Intent i=new Intent(MenuItem.this,DialActivityHw4.class);
                    startActivity(i);
                }
                else
                {
                    Intent i=new Intent(MenuItem.this,ProfileActivityHw4.class);
                    startActivity(i);
                }
            }
        });
    }
}
