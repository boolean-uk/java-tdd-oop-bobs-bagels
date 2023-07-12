package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addBagelTest() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLP)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLS)));
        Assertions.assertFalse(basket.addItem(new Bagel(BagelType.BGLE)));
    }
    @Test
    public void removeBagelTest() {
        Basket basket = new Basket();
        Bagel bagel1 = new Bagel(BagelType.BGLE);
        Bagel bagel2 = new Bagel(BagelType.BGLP);
        Assertions.assertTrue(basket.addItem(bagel1));
        Assertions.assertTrue(basket.addItem(bagel2));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.removeItem(bagel1));
        Assertions.assertTrue(basket.removeItem(BagelType.BGLP));
        Assertions.assertTrue(basket.removeItem(BagelType.BGLO));
        Assertions.assertFalse(basket.removeItem(BagelType.BGLE));
        Assertions.assertFalse(basket.removeItem(bagel1));
    }
    @Test
    public void isFullTest() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLP)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLO)));
        Assertions.assertFalse(basket.isFull());
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLS)));
        Assertions.assertTrue(basket.isFull());
    }
    @Test
    public void setCapacityTest() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLP)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLS)));
        Assertions.assertFalse(basket.addItem(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.setCapacity(6));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLS)));
        Assertions.assertFalse(basket.setCapacity(3));
    }

}
