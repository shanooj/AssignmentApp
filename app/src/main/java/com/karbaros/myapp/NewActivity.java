package com.karbaros.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shanu on 09-Jan-17.
 */

public class NewActivity extends AppCompatActivity {

    public void doSomething (View view) {
        TextView textview = (TextView) findViewById(R.id.tvresult);
        textview.setText("This is fromjava pgrm...");
        textview.setTextColor(Color.BLUE);
        textview.setTextSize(52.5F);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_layout);


        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

    }
}
