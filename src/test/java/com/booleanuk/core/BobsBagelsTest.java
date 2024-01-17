package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BobsBagelsTest {

    @Test
    public void addItemToBasketReturnTrue() {
        Basket basket = new Basket();

        boolean result = basket.addBagel("plain");
        Assertions.assertTrue(result);
    }


    @Test
    public void removeItemFromBasket() {
        Basket basket = new Basket();

        basket.addBagel("plain");
        boolean result = basket.removeBagel("plain");
        Assertions.assertTrue(result);
    }

    @Test
    public void removeItemNotInBasket() {
        Basket basket = new Basket();

        boolean result = basket.removeBagel("bread");
        Assertions.assertFalse(result);
    }

    @Test
    public void checkIfBasketIsFull() {
        Basket basket = new Basket();
        basket.addBagel("plain");
        basket.addBagel("chocolate");
        basket.addBagel("honey");
        basket.addBagel("salmon");

        Assertions.assertFalse(basket.addBagel("cheese"));


    }

    @Test
    public void checkIfBasketSizeCanIncrease() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(5);
        Assertions.assertEquals(9, basket.basketCapacity);
    }

    @Test
    public void checkIfBasketSizeCanDecrease() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(-2);
        Assertions.assertEquals(2, basket.basketCapacity);


    }
}