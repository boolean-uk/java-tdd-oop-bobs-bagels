package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void canAddBagel() {
        Basket basket = new Basket();
        assertTrue(basket.addItem("BGLO", 0.49, "Bagel", "Onion"));
    }
}
