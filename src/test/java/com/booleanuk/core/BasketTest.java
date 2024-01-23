package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    //User story 1
    @Test
    public void shouldReturnTrueIfBagelIsAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        boolean added = basket.addBagel(bagel);
        Assertions.assertTrue(added);
    }

    @Test void shouldReturnFalseIfBagelIsNotAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        boolean added = basket.addBagel(new Bagel("Sesame", "1234", 10));
        Assertions.assertFalse(added);
    }

    //User story 2
    @Test void shouldReturnTrueIfBagelIsRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        basket.addBagel(bagel);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertTrue(removed);
    }

    @Test void shouldReturnFalseIfBagelIsNotRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertFalse(removed);
    }

    //User story 3 is handled in user story 1 test cases

    //User story 4
    @Test void shouldAssertNewBasketSize() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        int originalSize = basket.maxCapacity;
        int newSize = basket.extendCapacityOfBasket(3);
        Assertions.assertEquals(newSize, originalSize+3);
    }


}
