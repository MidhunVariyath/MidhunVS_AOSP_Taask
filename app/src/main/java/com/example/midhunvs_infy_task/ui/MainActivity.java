package com.example.midhunvs_infy_task.ui;
// MainActivity.java (View)
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.midhunvs_infy_task.R;
import com.example.midhunvs_infy_task.viewmodel.CarRentalViewModel;

public class MainActivity extends AppCompatActivity {

    private CarRentalViewModel carRentalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ViewModel
        carRentalViewModel = new ViewModelProvider(this).get(CarRentalViewModel.class);

        // Set car rental details
        carRentalViewModel.setCarRental("John Doe", 100.0);

        //  exceeding limit
        carRentalViewModel.updateCurrentSpeed(120.0);

        // within the limit
        carRentalViewModel.updateCurrentSpeed(80.0);
    }
}
