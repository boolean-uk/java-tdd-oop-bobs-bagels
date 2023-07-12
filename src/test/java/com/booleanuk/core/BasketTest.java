package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addBagelTest() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addBagel(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.addBagel(new Bagel(BagelType.BGLP)));
        Assertions.assertTrue(basket.addBagel(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.addBagel(new Bagel(BagelType.BGLS)));
        Assertions.assertFalse(basket.addBagel(new Bagel(BagelType.BGLE)));
    }
}
