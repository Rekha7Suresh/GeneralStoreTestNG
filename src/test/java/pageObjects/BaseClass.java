package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    AndroidDriver<AndroidElement> appiumDriver;

    public AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Redmi Note 5 Pro");
        capabilities.setCapability("udid", "192.168.8.227:5555");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.androidsample.generalstore");
        capabilities.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver<AndroidElement>(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return appiumDriver;
    }

    @AfterTest
    public void tearDown() {
        appiumDriver.quit();
    }
}