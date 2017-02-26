package com.karbaros.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class BasicCalculatorActivity extends AppCompatActivity {

    TextView expressionString;

    public void doPrint(View view) {
        switch (view.getId()) {
            case R.id.btnOne :
                expressionString.append("1 ");
                break;
            case R.id.btnTwo :
                expressionString.append("2 ");
                break;
            case R.id.btnThree :
                expressionString.append("3 ");
                break;
            case R.id.btnFour :
                expressionString.append("4 ");
                break;
            case R.id.btnFive :
                expressionString.append("5 ");
                break;
            case R.id.btnSix :
                expressionString.append("6 ");
                break;
            case R.id.btnSeven :
                expressionString.append("7 ");
                break;
            case R.id.btnEight :
                expressionString.append("8 ");
                break;
            case R.id.btnNine :
                expressionString.append("9 ");
                break;
            case R.id.btnZero :
                expressionString.append("0 ");
                break;

            case R.id.btnDecimalPoint :
                expressionString.append(".");
                break;

            case R.id.btnAdd :
                expressionString.append("+ ");
                break;
            case R.id.btnSubstract :
                expressionString.append("- ");
                break;
            case R.id.btnmultiply :
                expressionString.append("* ");
                break;
            case R.id.btnDivide :
                expressionString.append("/ ");
                break;
            case R.id.btnMod :
                expressionString.append("% ");
                break;
            default:

                break;
        }

    }

    public void doClear(View view) {

        expressionString.setText("");

    }

    public void doDelete(View view) {


    }
    public void doCalcute(View view) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine sEngine = manager.getEngineByName("JavaScript");
        try {
            Object result = sEngine.eval(expressionString.getText().toString());
            expressionString.setText(result.toString());
        } catch (ScriptException e) {

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        expressionString = (TextView) findViewById(R.id.tvOperation);

        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }
    }
}
