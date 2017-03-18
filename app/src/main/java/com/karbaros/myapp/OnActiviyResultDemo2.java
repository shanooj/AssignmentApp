package com.karbaros.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OnActiviyResultDemo2 extends AppCompatActivity {
    EditText etName;
    Button btnSetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_activiy_result_demo2);
        etName = (EditText) findViewById(R.id.etName);
        btnSetName = (Button) findViewById(R.id.btnSetName);
        btnSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("NAME", etName.getText().toString());
                setResult(2,intent);
                finish();
            }
        });
    }
}
