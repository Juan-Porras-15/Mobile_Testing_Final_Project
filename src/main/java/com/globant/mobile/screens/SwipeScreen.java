package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Swipe-screen")
    public WebElement swipeContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    public WebElement swipeTitle;

    @AndroidFindBy(accessibility = "card")
    public List<WebElement> cards;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    public WebElement hiddenText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    public WebElement cardOneText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"GREAT COMMUNITY\")")
    public WebElement cardTwoText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"JS.FOUNDATION\")")
    public WebElement cardThreeText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SUPPORT VIDEOS\")")
    public WebElement cardFourText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"EXTENDABLE\")")
    public WebElement cardFiveText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"COMPATIBLE\")")
    public WebElement cardSixText;

    public SwipeScreen(AndroidDriver driver) { super(driver); }

    public void swipeToNextCard() {
        swipeHorizontal(0.90, 0.02, 0.6, 1500);
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        swipe(startX, startY, startX, endY, 200);
    }
}

