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

    @Test
    public void checkIfBasketSizeHandlesNegative() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(-10);
        Assertions.assertEquals(4, basket.basketCapacity);
    }

    @Test
    public void testTotalCostTwoItems(){
        Basket basket = new Basket();
        Order order = new Order();

        basket.addBagel("BGLP");
        basket.addBagel("BGLP");

        double total = order.getTotalCost(basket.bagelsList);
        Assertions.assertEquals(0.78, total);
    }
    @Test
    public void testTotalCostFiveItems(){
        Basket basket = new Basket();
        Order order = new Order();


        basket.addBagel("BGLP");
        basket.addBagel("BGLS");
        basket.addBagel("COFB");
        basket.addBagel("FILB");

        double total = order.getTotalCost(basket.bagelsList);
        Assertions.assertEquals(1.99, total);
    }
}