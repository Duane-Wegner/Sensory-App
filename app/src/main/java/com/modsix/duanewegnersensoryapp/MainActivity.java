package com.modsix.duanewegnersensoryapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity class that demonstrates how to use SensorManager
 * to access the device's accelerometer sensor.
 * This class implements SensorEventListener to receive sensor updates.
 */
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Manages access to the device's sensors
    private SensorManager sensorManager;

    // Reference to the accelerometer sensor
    private Sensor accelerometer;

    // TextView UI element to display sensor values on the screen
    private TextView sensorValueText;

    /**
     * Called when the activity is first created.
     * Sets up the UI and initializes sensor components.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout defined in activity_main.xml
        setContentView(R.layout.activity_main);

        // Link the TextView from the layout to this variable
        sensorValueText = findViewById(R.id.sensor_value);

        // Get the system sensor service to access device sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Obtain the default accelerometer sensor if available
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    /**
     * Called when the activity becomes visible to the user.
     * Register the sensor listener to start receiving updates.
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            // Register this class as a listener for accelerometer sensor events
            // SENSOR_DELAY_NORMAL means updates will be sent at a default rate
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    /**
     * Called when the activity is no longer visible.
     * Unregister the sensor listener to save battery and resources.
     */
    @Override
    protected void onPause() {
        super.onPause();
        // Stop listening to sensor updates when the app is paused
        sensorManager.unregisterListener(this);
    }

    /**
     * Called whenever there is new sensor data.
     * Updates the UI with the latest accelerometer readings.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        // Check that the event is from the accelerometer sensor
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Extract X, Y, and Z axis values from the sensor event
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Prepare a readable string to display sensor values
            String sensorText = "Accelerometer values:\n" +
                    "X: " + x + "\n" +
                    "Y: " + y + "\n" +
                    "Z: " + z;

            // Update the TextView on the screen with the sensor data
            sensorValueText.setText(sensorText);

            // Also print the sensor values to the console (Logcat) for debugging
            System.out.println(sensorText);
        }
    }

    /**
     * Called when sensor accuracy changes.
     * Not used in this app, so left empty.
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No action needed for this example
    }
}
