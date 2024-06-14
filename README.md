# **Appium Test Automation Project**

This project demonstrates how to automate tests for both iOS and Android applications using Appium with Java and Cucumber.

## Prerequisites

Before running the tests, ensure you have the following installed:

* Java Development Kit (JDK) 8 or higher
* Maven (for managing dependencies)
* Appium Server installed and running
* Android Studio (for Android emulator)
* Xcode (for iOS simulator)

## Setting Up

## 1. Clone the repository:

    git clone <repository_url>
    cd appium-test-automation

## 2. Install dependencies:

    mvn clean install

## 3. Start Appium Server:

Start the Appium server on the default port (4723) or specify a different port if needed.
    
`appium`

Ensure the Appium server is running before executing tests.

## Running Tests

### Android

Start an Android emulator using Android Studio.
Modify the deviceName and app capabilities in config.properties to match your Android emulator and application APK path.
`mvn test -Dtest=runners.TestRunner`

### iOS

Start an iOS simulator using Xcode.
Modify the deviceName, platformVersion, and app capabilities in config.properties. to match your iOS simulator and application path.
`mvn test -Dtest=runners.TestRunner`
Troubleshooting