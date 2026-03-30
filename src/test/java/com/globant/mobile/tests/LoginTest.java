package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.DataGenerator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    @Test(description = "Validar el flujo de login paso a paso con aserciones intermedias")
    public void testLoginStepByStep() {
        SoftAssert softAssert = new SoftAssert();
        String email = DataGenerator.getRandomEmail();
        String password = DataGenerator.getRandomPassword();
        int timeout = 10;

        LoginScreen loginScreen = new HomeScreen(driver)
                .clickLoginIcon()
                .createNewUser(email, password);

        softAssert.assertTrue(loginScreen.isElementClickable(loginScreen.loginTab, timeout), "La pestaña LOGIN no es clickeable");
        loginScreen.clickLoginTab();

        softAssert.assertTrue(loginScreen.isElementVisible(loginScreen.emailField, timeout), "El campo de EMAIL no es visible");
        loginScreen.sendKeysSafely(loginScreen.emailField, email, timeout);

        softAssert.assertTrue(loginScreen.isElementVisible(loginScreen.passwordField, timeout), "El campo de PASSWORD no es visible");
        loginScreen.sendKeysSafely(loginScreen.passwordField, password, timeout);

        softAssert.assertTrue(loginScreen.isElementClickable(loginScreen.loginButton, timeout), "El botón LOGIN no está habilitado para clic");
        loginScreen.clickLoginButton();

        softAssert.assertEquals(loginScreen.getAlertMessageText(), "You are logged in!", "El mensaje de éxito es incorrecto");

        loginScreen.clickOkButton();
        softAssert.assertAll();
    }
}