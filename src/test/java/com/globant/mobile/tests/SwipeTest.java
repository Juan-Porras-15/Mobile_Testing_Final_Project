package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.SwipeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test(description = "Validar el carrusel y scroll con Hard Asserts")
    public void testSwipeFlow() {
        SwipeScreen swipeScreen = new HomeScreen(driver).clickSwipeIcon();

        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.swipeTitle, 10),
                "El título de la pantalla Swipe no es visible.");

        swipeScreen.swipeToNextCard();
        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.cardTwoText, 5),
                "Error: No se visualiza la tarjeta 2");

        swipeScreen.swipeToNextCard();
        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.cardThreeText, 5),
                "Error: No se visualiza la tarjeta 3");

        swipeScreen.swipeToNextCard();
        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.cardFourText, 5),
                "Error: No se visualiza la tarjeta 4");

        swipeScreen.swipeToNextCard();
        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.cardFiveText, 5),
                "Error: No se visualiza la tarjeta 5");

        swipeScreen.swipeToNextCard();
        Assert.assertTrue(swipeScreen.isElementVisible(swipeScreen.cardSixText, 5),
                "Error: No se visualiza la tarjeta 6");

        boolean found = false;
        for (int i = 0; i < 5; i++) {
            if (swipeScreen.isElementVisible(swipeScreen.hiddenText, 1)) {
                found = true;
                break;
            }
            swipeScreen.scrollDown();
        }

        Assert.assertTrue(found, "¡Fallo crítico! El texto 'You found me!!!' no fue encontrado tras el scroll.");
    }
}