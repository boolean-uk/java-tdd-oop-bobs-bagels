package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    //TODO: dont need?
//    @Test
//    public void addValidFillingTest() {
//        Basket basket = new Basket();
//        Bagel bagel = new Bagel("onion");
//        bagel.addFilling(new Filling("Cheese"));
//        Assertions.assertEquals("Filling added.", basket.addItem(bagel));
//    }
//
//    @Test
//    public void addFillingToNonExistentBagelTest() {
//        Basket basket = new Basket();
//        basket.addItem(new Bagel("onion"));
//        String actual = basket.addFilling("Cheese", "Plain");
//        Assertions.assertEquals("Your basket doesn't contain that bagel.", actual);
//    }
//
//    @Test
//    public void addFillingThatAllGivenBagelsAlreadyHaveTest() {
//        Basket basket = new Basket();
//        basket.addItem(new Bagel("onion"));
//        basket.addItem(new Bagel("onion"));
//
//        basket.addFilling("Cheese", "Onion");
//        basket.addFilling("Cheese", "Onion");
//        basket.addFilling("Egg", "Onion");
//
//        String actual = basket.addFilling("Cheese", "Onion");
//        Assertions.assertEquals("All bagels of that kind in your basket already has that filling.", actual);
//    }
}
