package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WEBDRIVER\")")
    public WebElement homeTitle;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
}