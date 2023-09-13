package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class coreTest {
    @Test
    void addAndRemoveBagelsFromBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("BGLO",0.49d,"Onion");
        Assertions.assertTrue(basket.add(bagel));
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertFalse(basket.remove("panagiotis"));
    }
}
