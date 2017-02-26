package com.karbaros.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shanu on 09-Jan-17.
 */

public class GreetingActivity extends AppCompatActivity {

    private static final String TAG = GreetingActivity.class.getSimpleName();
    EditText fstName;
    EditText sndName;
    TextView tvGreet;
    public void userGreeting(View view) {
        String fName = fstName.getText().toString();
        String scndName = sndName.getText().toString();

        tvGreet.setText("Greeting " + fName + " " +scndName);

        Log.i(TAG, "INSIDE GREET METHOD");

        Toast.makeText(getBaseContext(),"Greeting " + fName + " " +scndName,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting_layout);

        fstName = (EditText) findViewById(R.id.etFirstName);
        sndName = (EditText) findViewById(R.id.etSecondName);
        tvGreet = (TextView) findViewById(R.id.tvGreet);

        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

    }
}
