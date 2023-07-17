package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addItemTest() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLE)));
        Assertions.assertTrue(basket.addItem(new Item(CoffeeType.COFL)));
        Assertions.assertTrue(basket.addItem(new Bagel(BagelType.BGLO)));
        Assertions.assertTrue(basket.addItem(BagelType.BGLS));
        Assertions.assertFalse(basket.addItem(new Bagel(BagelType.BGLE)));
    }
    @Test
    public void removeItemTest() {
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
        Item item = new Item(CoffeeType.COFB);
        Assertions.assertTrue(basket.addItem(item));
        Assertions.assertTrue(basket.removeItem(item));
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
    @Test
    public void getTotalPriceTest() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BagelType.BGLP);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILC);
        basket.addItem(bagel);
        basket.addItem(BagelType.BGLE);
        basket.addItem(CoffeeType.COFB);
        Assertions.assertEquals(2.35, basket.getTotalPrice());
        basket.removeItem(BagelType.BGLE);
        Assertions.assertEquals(1.86, basket.getTotalPrice());
    }
}
