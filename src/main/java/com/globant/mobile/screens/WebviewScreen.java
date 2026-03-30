package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.webkit.WebView")
    public WebElement webViewContent;

    public WebviewScreen(AndroidDriver driver) { super(driver); }
}