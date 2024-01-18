package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addValidFillingTest() {
        Basket basket = new Basket();
        basket.addBagel("onion");
        String actual = basket.addFilling("Cheese", "Onion");
        Assertions.assertEquals("Filling added.", actual);
    }

    @Test
    public void addFillingToNonExistentBagelTest() {
        Basket basket = new Basket();
        basket.addBagel("onion");
        String actual = basket.addFilling("Cheese", "Plain");
        Assertions.assertEquals("Your basket doesn't contain that bagel.", actual);
    }

    @Test
    public void addFillingThatAllGivenBagelsAlreadyHaveTest() {
        Basket basket = new Basket();
        basket.addBagel("onion");
        basket.addBagel("onion");

        basket.addFilling("Cheese", "Onion");
        basket.addFilling("Cheese", "Onion");
        basket.addFilling("Egg", "Onion");

        String actual = basket.addFilling("Cheese", "Onion");
        Assertions.assertEquals("All bagels of that kind in your basket already has that filling.", actual);
    }
}
