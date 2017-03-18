package com.karbaros.myapp;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {
    private SensorManager mSensorManager;
    private TextView tvSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tvSensorList = (TextView) findViewById(R.id.tvSensorList);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList= mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 1; i < sensorList.size(); i++) {

            tvSensorList.append("\n" + sensorList.get(i).getName() + "\n" + sensorList.get(i).getVendor() + "\n" + sensorList.get(i).getVersion() + "\n");
        }
    }
}
