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
    @Test
    public void removeBagelTest() {
        Basket basket = new Basket();
        Bagel bagel1 = new Bagel(BagelType.BGLE);
        Bagel bagel2 = new Bagel(BagelType.BGLP);
        Assertions.assertTrue(basket.addBagel(bagel1));
        Assertions.assertTrue(basket.addBagel(bagel2));
        Assertions.assertTrue(basket.addBagel(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.removeBagel(bagel1));
        Assertions.assertTrue(basket.removeBagel(BagelType.BGLP));
        Assertions.assertTrue(basket.removeBagel(BagelType.BGLO));
        Assertions.assertFalse(basket.removeBagel(BagelType.BGLE));
        Assertions.assertFalse(basket.removeBagel(bagel1));
    }
}
