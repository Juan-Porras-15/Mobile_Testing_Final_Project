package com.globant.mobile.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); // Cambia por tu ID de 'adb devices'
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\j.porras\\Documents\\Final_Project\\Mobile_Testing_Final\\src\\test\\resources\\apps\\android.wdio.native.app.v2.2.0.apk");
        options.setAppWaitActivity("com.wdiodemoapp.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}