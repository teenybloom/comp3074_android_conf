package com.example.a101019479.conference_app_mockup.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import com.example.a101019479.conference_app_mockup.R;

public class SensorActivity extends AppMenuCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView x;
    private TextView y;
    private TextView z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        x = findViewById(R.id.tvX);
        y = findViewById(R.id.tvY);
        z = findViewById(R.id.tvZ);
    }

    @Override
    protected void onResume() {
         super.onResume();
         sensorManager.registerListener(this,
                 sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                 sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] v = event.values;
        x.setText("x: "+ v[0]);
        y.setText("y: " + v[1]);
        z.setText("z: " + v[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
