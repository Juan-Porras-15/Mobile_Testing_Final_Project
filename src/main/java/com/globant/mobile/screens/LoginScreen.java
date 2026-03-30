package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Login-screen")
    public WebElement loginContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    public WebElement loginTitle;

    // Selectores para el Switch superior
    @AndroidFindBy(accessibility = "button-login-container")
    public WebElement loginTab;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    public WebElement signUpTab;

    // Campos del Formulario
    @AndroidFindBy(accessibility = "input-email")
    public WebElement emailField;

    @AndroidFindBy(accessibility = "input-password")
    public WebElement passwordField;

    @AndroidFindBy(accessibility = "input-repeat-password")
    public WebElement repeatPasswordField;

    // Botones de acción
    @AndroidFindBy(accessibility = "button-LOGIN")
    public WebElement loginButton;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    public WebElement signUpButton;

    // Alertas/Mensajes de éxito
    @AndroidFindBy(id = "android:id/message")
    public WebElement successMessage;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement okButton;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public void clickSignUpTab() { signUpTab.click(); }
    public void clickLoginTab() { loginTab.click(); }
    public void clickSignUpButton() { signUpButton.click(); }
    public void clickLoginButton() { loginButton.click(); }
    public void clickOkButton() { okButton.click(); }

    public void fillSignUpForm(String email, String password) {
        sendKeysSafely(emailField, email, 5);
        sendKeysSafely(passwordField, password, 5);
        sendKeysSafely(repeatPasswordField, password, 5);
    }

    public String getSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }
}