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

    @Test
    void manageBasketSize() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel("BGLO",0.49d,"Onion");
        Bagel bagel2 = new Bagel("BGLP",0.39d,"Plain");
        basket.add(bagel1);
        Assertions.assertFalse(basket.add(bagel2));
    }
}
