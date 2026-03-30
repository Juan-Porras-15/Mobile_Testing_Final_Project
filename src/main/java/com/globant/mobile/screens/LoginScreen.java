package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Login-screen")
    public WebElement loginContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    public WebElement loginTitle;

    public LoginScreen(AndroidDriver driver) { super(driver); }
}