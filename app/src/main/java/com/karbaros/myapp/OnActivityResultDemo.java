package com.karbaros.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnActivityResultDemo extends AppCompatActivity {
    Button btnGetName;
    TextView tvResultName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_demo);
        tvResultName = (TextView) findViewById(R.id.tvResultName);
        btnGetName = (Button) findViewById(R.id.btnGetName);
        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGetName = new Intent(OnActivityResultDemo.this, OnActiviyResultDemo2.class);
                startActivityForResult(intentGetName, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            tvResultName.setText(data.getStringExtra("NAME"));
        }
    }
}
