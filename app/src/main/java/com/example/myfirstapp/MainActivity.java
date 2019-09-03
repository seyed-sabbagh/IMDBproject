package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CycleMethod","OnCreate Method is Running");

        Button btnMenu=findViewById(R.id.btnDrawer);
        final DrawerLayout myDrawer=findViewById(R.id.drawerMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDrawer.openDrawer(GravityCompat.START);


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CycleMethod","OnStart Method is Running");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CycleMethod","OnResume Method is Running");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CycleMethod","OnPause Method is Running");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CycleMethod","OnStop Method is Running");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CycleMethod","OnDestroy Method is Running");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CycleMethod","OnRestart Method is Running");

    }
}
