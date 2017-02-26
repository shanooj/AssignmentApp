package com.karbaros.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;


public class CurrencyConverterActivity extends AppCompatActivity {

    private static final String TAG = CurrencyConverterActivity.class.getSimpleName();
    private Spinner fromSpinner;
    private Spinner toSpinner;
    EditText etToCurrency;
    private static EditText etFromCurrency;
    private double fromCurrencyValue = 0;
    private double toCurrencyValue = 0;
    private HashMap<String, Double> rupeesRate = new HashMap<String, Double>();
    private HashMap<String, Double> usdRate = new HashMap<String, Double>();
    private HashMap<String, Double> jpyRate = new HashMap<String, Double>();
    private HashMap<String, Double> chfRate = new HashMap<String, Double>();
    private HashMap<String, Double> euroRate = new HashMap<String, Double>();


    public void doConvert(View view) {

        try {
            fromCurrencyValue = Double.parseDouble(etFromCurrency.getText().toString());
            // toCurrencyValue = Double.parseDouble(etToCurrency.getText().toString());
        } catch (Exception e) {
            etFromCurrency.setError("Enter Value");
        }
        if (fromCurrencyValue == 0)
            etFromCurrency.setError("Enter Value");
        else {
            final String fromCurrency = fromSpinner.getSelectedItem().toString();

            final String toCurrency = toSpinner.getSelectedItem().toString();


            switch (fromCurrency) {
                case "INR":

                    switch (toCurrency) {
                        case "INR":
                            Double d = 0.0;

                            d = rupeesRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d));
                            break;
                        case "USD":
                            d = rupeesRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d));
                            break;
                        case "JPY":
                            d = rupeesRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d));
                            break;
                        case "CHF":
                            d = rupeesRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d));
                            break;
                        case "Euro":
                            d = rupeesRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d));
                            break;
                        default:
                            break;
                    }
                    break;
                case "USD":
                    switch (toCurrency) {
                        case "INR":
                            double d1 = usdRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d1));
                            break;
                        case "USD":
                            d1 = usdRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d1));
                            break;
                        case "JPY":
                            d1 = usdRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d1));
                            break;
                        case "CHF":
                            d1 = usdRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d1));
                            break;
                        case "Euro":
                            d1 = usdRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d1));
                            break;
                        default:
                            break;
                    }
                    break;
                case "JPY":
                    switch (toCurrency) {
                        case "INR":
                            double d2 = jpyRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d2));
                            break;
                        case "USD":
                            d2 = jpyRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d2));
                            break;
                        case "JPY":
                            d2 = jpyRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d2));
                            break;
                        case "CHF":
                            d2 = jpyRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d2));
                            break;
                        case "Euro":
                            d2 = jpyRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d2));
                            break;
                        default:
                            break;
                    }
                    break;
                case "CHF":
                    switch (toCurrency) {
                        case "INR":
                            double d3 = chfRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d3));
                            break;
                        case "USD":
                            d3 = chfRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d3));
                            break;
                        case "JPY":
                            d3 = chfRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d3));
                            break;
                        case "CHF":
                            d3 = chfRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d3));
                            break;
                        case "Euro":
                            d3 = chfRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d3));
                            break;
                        default:
                            break;
                    }
                    break;
                case "Euro":
                    switch (toCurrency) {
                        case "INR":
                            double d4 = euroRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d4));
                            break;
                        case "USD":
                            d4 = euroRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d4));
                            break;
                        case "JPY":
                            d4 = euroRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d4));
                            break;
                        case "CHF":
                            d4 = euroRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d4));
                            break;
                        case "Euro":
                            d4 = euroRate.get(toCurrency) * fromCurrencyValue;
                            etToCurrency.setText(Double.toString(d4));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        fromSpinner = (Spinner) findViewById(R.id.spFromcurrency);
        toSpinner = (Spinner) findViewById(R.id.spToCurrency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        fromSpinner.setSelection(0);
        toSpinner.setAdapter(adapter);
        toSpinner.setSelection(1);
        etToCurrency = (EditText) findViewById(R.id.etToCurrency);
        etFromCurrency = (EditText) findViewById(R.id.etFromCurrency);

        // currency values
        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        // rupees rates
        rupeesRate.put("INR", 1.0);
        rupeesRate.put("USD", 0.015);
        rupeesRate.put("JPY", 1.7);
        rupeesRate.put("CHF", 0.02);
        rupeesRate.put("Euro", 0.014);

        // USD rates
        usdRate.put("INR", 66.95);
        usdRate.put("USD", 1.0);
        usdRate.put("JPY", 113.45);
        usdRate.put("CHF", 1.01);
        usdRate.put("Euro", 0.95);

        //JPY rates
        jpyRate.put("INR", 0.59);
        jpyRate.put("USD", 0.0088);
        jpyRate.put("JPY", 1.0);
        jpyRate.put("CHF", 0.0089);
        jpyRate.put("Euro", 0.0084);

        //CHF RATE
        chfRate.put("INR", 66.22);
        chfRate.put("USD", 0.99);
        chfRate.put("JPY", 112.27);
        chfRate.put("CHF", 1.0);
        chfRate.put("Euro", 0.94);

        //EURO RATES
        euroRate.put("INR", 70.45);
        euroRate.put("USD", 1.05);
        euroRate.put("JPY", 119.4);
        euroRate.put("CHF", 1.06);
        euroRate.put("Euro", 1.0);


    }
}
