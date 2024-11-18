package com.example.midhunvs_infy_task.viewmodel;
// CarRentalViewModel.java (ViewModel)
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.midhunvs_infy_task.model.CarRental;
import com.example.midhunvs_infy_task.model.SpeedAlert;

public class CarRentalViewModel extends ViewModel {

    private CarRental carRental;
    private SpeedAlert speedAlert;
    private MutableLiveData<String> warningMessage = new MutableLiveData<>();

    public CarRentalViewModel() {
        speedAlert = new SpeedAlert();
    }

    // Initialize car Rental details
    public void setCarRental(String customerName, double speedLimit) {
        this.carRental = new CarRental(customerName, speedLimit);
    }

    // Update current Speed and check if it exceeds the limit
    public void updateCurrentSpeed(double currentSpeed) {
        if (carRental != null) {
            carRental.setCurrentSpeed(currentSpeed);
            Log.d(TAG, " CarRentalViewModel=CusName= " + carRental.getCustomerName());
            Log.d(TAG, " CarRentalViewModel=currentSpeed= " + currentSpeed);
            Log.d(TAG, " CarRentalViewModel=SpeedLimit= " + carRental.getSpeedLimit());
            // Check if speed is exceeded
            if (carRental.isSpeedExceeded()) {
                speedAlert.sendAlert(carRental.getCustomerName(), currentSpeed, carRental.getSpeedLimit());
                warningMessage.setValue("Speed limit exceeded!");
                Log.d(TAG, "CarRentalViewModel----exceeded");
                ///// ----------------FIREBASE API IS NOT ADDED ------------
                // Trigger Firebase Notification when speed exceeds limit
                sendFirebaseNotification("Speed Limit Exceeded!",
                        carRental.getCustomerName() + " is driving at " + currentSpeed + " km/h, exceeding the limit.");
            } else {
                warningMessage.setValue("Speed is within the limit.");
                Log.d(TAG, "CarRentalViewModel----Limit");
            }
        }
    }


    private void sendFirebaseNotification(String title, String message) {
        // You can send a notification via Firebase to a specific topic, or user
        FirebaseMessaging.getInstance().send(new RemoteMessage.Builder("_name@fcm.googleapis.com")
                .setMessageId(Integer.toString((int) System.currentTimeMillis()))
                .addData("title", title)
                .addData("message", message)
                .build());
    }
}
