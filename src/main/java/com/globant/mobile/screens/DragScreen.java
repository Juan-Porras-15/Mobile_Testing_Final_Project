package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Drag-drop-screen")
    public WebElement dragContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    public WebElement dragTitle;

    public DragScreen(AndroidDriver driver) { super(driver); }
}