package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;
    private Item testItem;

    @Test
    public void addBagelTest(){
        basket = new Basket(10);
        testItem = new Item("Beige", 1.23);
        Assertions.assertTrue(basket.addBagel(testItem));
    }
    @Test
    public void removeBagelTest(){
        basket = new Basket(10);
        testItem = new Item("Beige", 1.23);
        basket.addBagel(testItem);
        Assertions.assertTrue(basket.removeBagel(testItem));
    }
}
