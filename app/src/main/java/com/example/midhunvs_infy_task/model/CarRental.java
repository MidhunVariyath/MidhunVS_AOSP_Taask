package com.example.midhunvs_infy_task.model;

public class CarRental {
    private String customerName;
    private double speedLimit;
    private double currentSpeed;

    public CarRental(String customerName, double speedLimit) {
        this.customerName = customerName;
        this.speedLimit = speedLimit;
        this.currentSpeed = 0.0;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isSpeedExceeded() {
        return currentSpeed > speedLimit;
    }

    public String getCustomerName() {
        return customerName;
    }
}
