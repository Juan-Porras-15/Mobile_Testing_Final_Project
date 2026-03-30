package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.LogInspector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.login.LoginContext;
import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeIcon;

    @AndroidFindBy(accessibility = "Webview")
    public WebElement webviewIcon;

    @AndroidFindBy(accessibility = "Login")
    public WebElement loginIcon;

    @AndroidFindBy(accessibility = "Forms")
    public WebElement formsIcon;

    @AndroidFindBy(accessibility = "Swipe")
    public WebElement swipeIcon;

    @AndroidFindBy(accessibility = "Drag")
    public WebElement dragIcon;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isElementVisible(WebElement element, int seconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public HomeScreen clickHomeIcon() {
        homeIcon.click();
        return new HomeScreen(driver);
    }
    public WebviewScreen clickWebviewIcon() {
        webviewIcon.click();
        return new WebviewScreen(driver);
    }
    public LoginScreen clickLoginIcon() {
        loginIcon.click();
        return new LoginScreen(driver);
    }
    public FormsScreen clickFormsIcon() {
        formsIcon.click();
        return new FormsScreen(driver);
    }
    public SwipeScreen clickSwipeIcon() {
        swipeIcon.click();
        return new SwipeScreen(driver);
    }
    public DragScreen clickDragIcon() {
        dragIcon.click();
        return new DragScreen(driver);
    }
}