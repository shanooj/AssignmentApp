package com.karbaros.myapp;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorValueActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView tvX;
    private TextView tvY;
    private  TextView tvZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_value);

        tvX = (TextView) findViewById(R.id.tvXValue);
        tvY = (TextView) findViewById(R.id.tvYValue);
        tvZ = (TextView) findViewById(R.id.tvZValue);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor
                (Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            tvX.setText(Float.toString(sensorEvent.values[0]));
            tvY.setText(Float.toString(sensorEvent.values[1]));
            tvZ.setText(Float.toString(sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }
}
