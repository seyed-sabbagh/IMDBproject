package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CycleMethod","OnCreate Method is Running");
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
