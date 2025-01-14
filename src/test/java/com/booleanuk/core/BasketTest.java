package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BasketTest {
    private Basket basket;
    private Item bagel;
    private Item coffee;
    private Item filling;

    @BeforeEach
    public void setUp() {
        ArrayList<Item> basketItems = new ArrayList<>() {{
            add(bagel);
            add(coffee);
            add(filling);
        }};
        basket = new Basket(basketItems);
        bagel = new Item("BGLS", 0.49, "Bagel", "Sesame");
        coffee = new Item("COFB", 0.99, "Coffee" , "Black");
        filling = new Item("FILX", 0.12, "Filling", "Cream Cheese");
    }

    @Test
    public void testAddItem() {
        Assertions.assertTrue(basket.addItem(coffee));
        Assertions.assertTrue(basket.addItem(bagel));
        Assertions.assertTrue(basket.addItem(filling));
    }

    @Test
    public void testGetTotalPrice() {
        ArrayList<Item> basketItems = new ArrayList<>() {{
            add(bagel);
            add(coffee);
            add(filling);
        }};
        Assertions.assertEquals(1.60, basket.getTotalPrice(basketItems));
    }

}
