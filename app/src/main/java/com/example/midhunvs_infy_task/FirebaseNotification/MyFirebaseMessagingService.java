package com.example.midhunvs_infy_task.FirebaseNotification;
// File: MyFirebaseMessagingService.java
package com.example.carrentalapp;

import android.util.Log;
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;


///// ----------------FIREBASE API IS NOT ADDED ------------
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            // You can use a NotificationManager to show the notification here
        }
    }

    @Override
    public void onNewToken(String token) {
        // Get new FCM registration token
        Log.d(TAG, "New FCM Token: " + token);
    }
}
