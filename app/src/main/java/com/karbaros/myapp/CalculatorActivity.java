package com.karbaros.myapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;
    TextView tvResultCalc;

    public void doCalcute(View view) {
        double num1, num2;
        num1 = 0;
        num2 = 0;

        try{
            num1 = Double.parseDouble(etNum1.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(),"Enter 1st number",Toast.LENGTH_LONG).show();
            return;
        }
        try{
            num2 = Double.parseDouble(etNum2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(),"Enter 2nd number",Toast.LENGTH_LONG).show();
            return;
        }

        switch (view.getId()) {
            case R.id.btnAdd:
                tvResultCalc.setText("" + (num1 + num2));
                break;
            case R.id.btnSub:
                tvResultCalc.setText("" + (num1 - num2));
                break;
            case R.id.btnDiv:
                tvResultCalc.setText("" + (num1 / num2));
                break;
            case R.id.btnMultiple:
                tvResultCalc.setText("" + (num1 * num2));
                break;
            case R.id.btnMod:
                tvResultCalc.setText("" + (num1 % num2));
                break;

        }


    }
    public void doClear(View view) {
        tvResultCalc.setText("");
        etNum1.setText("");
        etNum2.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        tvResultCalc = (TextView) findViewById(R.id.tvResultCalc);

        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }


    }
}
