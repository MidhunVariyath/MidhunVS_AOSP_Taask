--------- Car Speed Limi Project -------
**Requirment**: A car rental company wants notifications if the renter of a car drives at a speed above a given limit.The limit shall be set by the fleet.
Here im following MVVM pattern. 
Model class -- CarRental.java: Represents the car rental data (customer info, speed limit).
            --- SpeedAlert.java: Handles logic for checking speed limits and sending notifications.
ViewModel -- Managing the logic part.
View      --- Observe the ViewModel to update the UI.
Firebase notification channel  --- For notification im using firebase (API not included in the project)
