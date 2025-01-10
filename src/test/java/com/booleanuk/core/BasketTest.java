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
    public void canAndDoesRemoveBagel() {
        Basket basket = new Basket();
        assertTrue(basket.addItem("BGLO", 0.49, "Bagel", "Onion"));
        assertTrue(basket.removeItem("BGLO"));
        assertTrue(basket.getItems().size() == 0);
    }
}
