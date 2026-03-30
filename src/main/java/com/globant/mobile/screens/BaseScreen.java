package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.LogInspector;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.login.LoginContext;
import java.time.Duration;
import java.util.Arrays;

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

    /**
     * Envía texto de forma segura a un elemento: espera visibilidad, limpia el campo y oculta el teclado.
     * @param element El WebElement (Input)
     * @param text El texto a escribir
     * @param timeout Tiempo de espera en segundos
     */
    public void sendKeysSafely(WebElement element, String text, int timeout) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));

            element.clear();
            element.sendKeys(text);

            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al enviar texto al elemento: " + e.getMessage());
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

    public void swipe(int startX, int startY, int endX, int endY, int milisDuration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(150), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(milisDuration), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    public void swipeHorizontal(double startPct, double endPct, double anchorPct, int milisDuration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPct);
        int start = (int) (size.width * startPct);
        int end = (int) (size.width * endPct);
        swipe(start, anchor, end, anchor, milisDuration);
    }
}