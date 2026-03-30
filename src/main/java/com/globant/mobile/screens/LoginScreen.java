package com.globant.mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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
    public WebElement alertMessage;

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

        if (isElementVisible(alertMessage, 10)) {
            return alertMessage.getText();
        }
        return "";
    }

    public void login(String email, String password) {
        clickLoginTab();
        sendKeysSafely(emailField, email, 10);
        sendKeysSafely(passwordField, password, 10);
        clickLoginButton();
    }

    public String getAlertMessageText() {
        if (isElementVisible(alertMessage, 10)) {
            return alertMessage.getText();
        }
        return "";
    }

    public LoginScreen createNewUser(String email, String password) {
        ;
        clickSignUpTab();
        fillSignUpForm(email, password);
        clickSignUpButton();

        String alertText = this.getSuccessAlertMessage();
        if (!alertText.equals("You successfully signed up!")) {
            throw new RuntimeException("Error: No se mostró la alerta de éxito al crear el usuario.");
        }

        clickOkButton();
        return this;
    }
}