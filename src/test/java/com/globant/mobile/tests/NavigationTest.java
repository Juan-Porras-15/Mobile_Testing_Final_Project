package com.globant.mobile.tests;

import com.globant.mobile.screens.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigationTest extends BaseTest {

    @Test(description = "Validar la navegación completa de la barra inferior con asserts de contenido")
    public void testBottomNavigation() {
        HomeScreen home = new HomeScreen(driver);
        SoftAssert softAssert = new SoftAssert();
        int timeout = 5;

        // 0. HOME
        softAssert.assertTrue(home.isElementVisible(home.homeTitle, timeout), "No se inicio el Home");

        // 1. WEBVIEW
        softAssert.assertTrue(home.isElementClickable(home.webviewIcon, timeout), "Icono WEBVIEW no clickable");
        WebviewScreen webview = home.clickWebviewIcon();
        softAssert.assertTrue(webview.isElementVisible(webview.webViewContent, timeout), "No se cargó el contenido de WEBVIEW");

        // 2. LOGIN
        softAssert.assertTrue(home.isElementClickable(home.loginIcon, timeout), "Icono LOGIN no clickable");
        LoginScreen login = home.clickLoginIcon();
        softAssert.assertTrue(home.isElementVisible(login.loginTitle, timeout), "No se llegó a LOGIN");

        // 3. FORMS
        softAssert.assertTrue(home.isElementClickable(home.formsIcon, timeout), "Icono FORMS no clickable");
        FormsScreen forms = home.clickFormsIcon();
        softAssert.assertTrue(forms.isElementVisible(forms.formsTitle, timeout), "No se llegó a FORMS");

        // 4. SWIPE
        softAssert.assertTrue(home.isElementClickable(home.swipeIcon, timeout), "Icono SWIPE no clickable");
        SwipeScreen swipe = home.clickSwipeIcon();
        softAssert.assertTrue(swipe.isElementVisible(swipe.swipeTitle, timeout), "No se llegó a SWIPE");

        // 5. DRAG
        softAssert.assertTrue(home.isElementClickable(home.dragIcon, timeout), "Icono DRAG no clickable");
        DragScreen drag = home.clickDragIcon();
        softAssert.assertTrue(drag.isElementVisible(drag.dragTitle, timeout), "No se llegó a DRAG");

        // 6. HOME (Regreso)
        softAssert.assertTrue(home.isElementClickable(home.homeIcon, timeout), "Icono HOME no clickable");
        home.clickHomeIcon();
        softAssert.assertTrue(home.isElementVisible(home.homeTitle, timeout), "No se regresó a HOME");

        softAssert.assertAll();
    }
}