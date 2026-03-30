package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Swipe-screen")
    public WebElement swipeContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    public WebElement swipeTitle;

    public SwipeScreen(AndroidDriver driver) { super(driver); }
}

