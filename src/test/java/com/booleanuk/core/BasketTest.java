package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addValidFillingTest() {
        Basket basket = new Basket();
        basket.addBagel(new Bagel("Onion"));
        String actual = basket.addFilling("Cheese", "Onion");
        Assertions.assertEquals("Filling added.", actual);
    }

    @Test
    public void addFillingToNonExistentBagelTest() {
        Basket basket = new Basket();
        basket.addBagel(new Bagel("Onion"));
        String actual = basket.addFilling("Cheese", "Plain");
        Assertions.assertEquals("Your basket doesn't contain that bagel.", actual);
    }

}
