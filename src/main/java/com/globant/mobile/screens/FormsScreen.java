package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Forms-screen")
    public WebElement formsContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    public WebElement formsTitle;

    public FormsScreen(AndroidDriver driver) { super(driver); }
}