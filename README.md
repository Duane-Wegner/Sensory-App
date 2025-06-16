# DuaneWegnerSensoryApp

This is a simple Android application created for **CS 360 - Mobile Architect & Programming**. The purpose of this app is to demonstrate the use of Android’s `SensorManager` class to access and display real-time accelerometer sensor data.

## 📱 Features

- Uses `SensorManager` to access the **accelerometer** sensor.
- Reads and displays sensor values (X, Y, Z axes) on screen.
- Real-time data updates based on physical device movement.
- Designed to run on the Android Emulator or physical device.

## 🛠 How It Works

When the app starts, it registers a listener to receive updates from the device’s accelerometer. As the device moves, the values from the sensor are updated on screen in real time. The app uses a `TextView` to display the values and also prints them to the console for debugging.

### Key Components:
- `MainActivity.java`: Handles sensor initialization and updates.
- `activity_main.xml`: Layout file containing a `TextView` for sensor output.
- `SensorManager`: Manages interaction with the accelerometer hardware.

## 🚀 How to Run

1. Open the project in **Android Studio**.
2. Build and run the project using the **Android Emulator** or a physical device.
3. Move the device (or use emulator controls) to see the accelerometer values update.

## 🧪 Testing & Debugging

- Breakpoints can be set in `onSensorChanged()` to observe when values update.
- Sensor values print to **Logcat** for debugging.

## 🧾 Requirements

- Android Studio (latest version)
- Android API level 21 or higher
- Emulator or physical Android device with accelerometer

## 📚 What I Learned

This project helped me understand how `SensorManager` works in real Android apps. I practiced registering sensor listeners, managing lifecycle events, and debugging sensor-driven features in a real development environment.

---

© 2025 Duane Wegner | SNHU CS 360
