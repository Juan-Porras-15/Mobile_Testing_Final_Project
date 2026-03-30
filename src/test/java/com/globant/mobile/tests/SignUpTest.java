package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(description = "Validar el registro exitoso de un nuevo usuario con datos aleatorios")
    public void testSuccessfulSignUp() {
        HomeScreen home = new HomeScreen(driver);
        String email = DataGenerator.getRandomEmail();
        String password = DataGenerator.getRandomPassword();

        LoginScreen loginScreen = home.clickLoginIcon();
        loginScreen.clickSignUpTab();

        loginScreen.fillSignUpForm(email, password);
        loginScreen.clickSignUpButton();

        String alertText = loginScreen.getSuccessAlertMessage();
        Assert.assertEquals(alertText, "You successfully signed up!", "El mensaje de éxito no es el esperado");

        loginScreen.clickOkButton();
    }
}