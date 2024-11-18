package com.example.midhunvs_infy_task.model;

import android.widget.Toast;

import com.example.midhunvs_infy_task.ui.MainActivity;

public class SpeedAlert {

    // Notify about exceeding the speed limit
    public void sendAlert(String customerName, double speed, double speedLimit) {
        System.out.println("ALERT: " + customerName + " exceeded the speed limit. Speed: " + speed + " km/h (Limit: " + speedLimit + " km/h)");
    }

    // Warn the customer about exceeding the speed limit
    public void sendWarning(String customerName, double speedLimit) {
        System.out.println("WARNING: " + customerName + ", you are exceeding the speed limit of " + speedLimit + " km/h!");
    }
}

