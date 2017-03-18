package com.karbaros.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent = new Intent(SplashScreenActivity.this,ActivityNavigater.class);
                startActivity(intent);

                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
