package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketTest {

    @BeforeEach
    public void clearLists(){
        Basket basket = new Basket();
        basket.clearList();
    }

    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add("plain"));
        Assertions.assertFalse(basket.add(""));
    }
    @Test
    public void testTryRemoveBagelFromList(){
        Basket basket = new Basket();
        basket.add("plain");
        basket.add("onion");
        Assertions.assertEquals(2, basket.basket.size());
        Assertions.assertTrue(basket.remove("onion"));
        Assertions.assertEquals(1, basket.basket.size());
    }
    @Test
    public void testCheckIfBasketIsFull(){
        Basket basket = new Basket();
        basket.add("bagel 0");
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 1; i < 5; i++) {
            basket.add("bagel " + i);
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
        for (int i = 5; i < 9; i++) {
            basket.add("bagel " + i);
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
    }
    @Test
    public void testChangeCapacityOfBasket(){
        Basket basket = new Basket();
        basket.add("bagel 0");
        basket.changeCapacity(17);
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 1; i < 5; i++) {
            basket.add("bagel " + i);
        }
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 5; i < 9; i++) {
            basket.add("bagel " + i);
        }
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 10; i < 18; i++) {
            basket.add("bagel " + i);
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
    }
    @Test
    public void testTryRemoveBagel(){
        Basket basket = new Basket();
        basket.add("Plain");
        basket.add("Chocolate");
        basket.add("Onion");
        Assertions.assertFalse(basket.remove("Redberry"));
        Assertions.assertTrue(basket.remove("Onion"));
        Assertions.assertFalse(basket.remove("Onion"));
    }
    @Test
    public void testTotalCostOfBasket(){
        Basket basket = new Basket();
        basket.add("Onion", 25.00);
        basket.add("Chocolate", 30.00);
        basket.add("Red berry", 35.00);
        Assertions.assertEquals(90, basket.totalCost());
    }

}
