package com.example.projectone.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projectone.R;
import com.example.projectone.User.UserDashboardActivity;

public class SplashScreen extends AppCompatActivity {

        Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, UserDashboardActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
}}