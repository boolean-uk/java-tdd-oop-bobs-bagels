package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {
    private Basket basket;
    private Item bagel;
    private Item coffee;
    private Item filling;

    @BeforeEach
    public void setUp() {
        HashMap<String, Double> basketItems = new HashMap<>();
        basket = new Basket(basketItems);
        bagel = new Item("BGLS", 0.49, "Bagel", "Sesame");
        coffee = new Item("COFB", 0.99, "Coffee" , "Black");
        filling = new Item("FILX", 0.12, "Filling", "Cream Cheese");
    }

    @Test
    public void testAddItem() {
        Assertions.assertTrue(basket.addItem(coffee.getName(), coffee.getPrice()));
        Assertions.assertTrue(basket.addItem(bagel.getName(), bagel.getPrice()));
        Assertions.assertTrue(basket.addItem(filling.getName(), filling.getPrice()));
    }



}
