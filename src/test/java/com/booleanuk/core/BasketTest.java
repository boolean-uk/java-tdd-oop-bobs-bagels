package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void canAddBagel() {
        Basket basket = new Basket();
        assertTrue(basket.addItem("BGLO", 0.49, "Bagel", "Onion"));
    }

    @Test
    public void addingBagelIncreasesBasketSize() {
        Basket basket = new Basket();
        basket.addItem("BGLO", 0.49, "Bagel", "Onion");
        assertEquals(1, basket.getItems().size());
    }

    @Test
    public void canAndDoesRemoveBagel() {
        Basket basket = new Basket();
        assertTrue(basket.addItem("BGLO", 0.49, "Bagel", "Onion"));
        assertTrue(basket.removeItem("BGLO"));
        assertTrue(basket.getItems().isEmpty());
    }

    @Test
    public void removesCorrectBagel() {
        Basket basket = new Basket();
        basket.addItem("BGLO", 0.49, "Bagel", "Onion");
        basket.addItem("BGLP", 0.39, "Bagel", "Plain");
        basket.removeItem("BGLP");
        assertNotEquals("BGLP", basket.getItems().getFirst().getSKU());
    }
}
