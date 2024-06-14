package utils;

import config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class DriverManager {
    private static AppiumDriver driver;
    public void initializeDriver() throws MalformedURLException {
        String platform = Config.getProperty("platform");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if ("Android".equalsIgnoreCase(platform)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", Config.getProperty("androidDeviceName"));
            capabilities.setCapability("automationName", Config.getProperty("androidAutomationName"));
            capabilities.setCapability("appWaitPackage", Config.getProperty("androidAppPackage"));
            capabilities.setCapability("appWaitActivity", Config.getProperty("androidAppActivity"));
            capabilities.setCapability("noRest", "True");
            String appPath = Paths.get(Config.getProperty("androidAppLocation")).toAbsolutePath().toString();
            capabilities.setCapability("app", appPath);
            driver = new AndroidDriver(new URL(Config.getProperty("appiumURL")), capabilities);
        } else if ("iOS".equalsIgnoreCase(platform)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", Config.getProperty("iOSDeviceName"));
            capabilities.setCapability("automationName", Config.getProperty("iOSAutomationName"));
            capabilities.setCapability("udid", Config.getProperty("iOSUdid"));
            capabilities.setCapability("wdaLaunchTimeout", 12000);
            String appPath = Paths.get(Config.getProperty("iOSAppLocation")).toAbsolutePath().toString();
            capabilities.setCapability("app", appPath);
            driver = new IOSDriver(new URL(Config.getProperty("appiumURL")), capabilities);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
    public AppiumDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
