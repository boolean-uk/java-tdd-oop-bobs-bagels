package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;
    private Item bagel;
    private Item coffee;
    private Item filling;

    @BeforeEach
    public void setUp() {
        basket = new Basket(4);
        bagel = new Item("BGLS", "Sesame", 0.49, "Bagel");
        coffee = new Item("COFB", "Black", 0.99 , "Coffee");
        filling = new Item("FILX", "Cream Cheese", 0.12, "Filling");
    }

    @Test
    public void testAddItem() {
        Assertions.assertTrue(basket.addItem(coffee));
        Assertions.assertTrue(basket.addItem(bagel));
        Assertions.assertTrue(basket.additem(filling));
    }



}
