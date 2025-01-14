package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addBagelCorrectlyTest() {
        Basket basket = new Basket();
        basket.addItem(SKU.BGLP);
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertEquals(SKU.BGLP, basket.items.getFirst().SKU);
    }

    @Test
    public void addBagelCorrectlyTest2() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem(SKU.BGLP));
    }

    @Test
    public void addBagelIncorrectlyTest() {
        Basket basket = new Basket();
        basket.addItem(SKU.BGLP);
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertNotEquals(SKU.BGLE, basket.items.getFirst().getSKU());
    }

    @Test
    public void removeBagelCorrectlyTest() {
        Basket basket = new Basket();
        basket.addItem(SKU.BGLP);
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertTrue(basket.removeBagel(SKU.BGLP));
        Assertions.assertEquals(0, basket.items.size());
    }

    @Test
    public void removeBagelIncorrectlyTest() {
        Basket basket = new Basket();
        basket.addItem(SKU.BGLP);
        Assertions.assertFalse(basket.removeBagel(SKU.BGLE));
    }

    @Test
    public void removeBagelIncorrectlyTest2() {
        Basket basket = new Basket();
        basket.addItem(SKU.BGLP);
        Assertions.assertFalse(basket.removeBagel(SKU.COFW));
    }

    @Test
    public void changeCapacityCorrectlyTest() {
        Basket basket = new Basket();
        basket.setCapacity(10);
        Assertions.assertEquals(10, basket.getCapacity());
    }

    @Test
    public void changeCapacityCorrectlyTest2() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.setCapacity(10));
    }

    @Test
    public void changeCapacityIncorrectlyTest() {
        Basket basket = new Basket();
        Assertions.assertFalse(basket.setCapacity(-5));
    }

    @Test
    public void changeCapacityIncorrectlyTest2() {
        Basket basket = new Basket();
        basket.setCapacity(-20);
        Assertions.assertNotEquals(-20, basket.getCapacity());
    }

    @Test
    public void changeCapacityIncorrectlyTest3() {
        Basket basket = new Basket();
        Bagel bagel1 = new Bagel(SKU.BGLP);
        Bagel bagel2 = new Bagel(SKU.BGLO);
        Coffee coffee = new Coffee(SKU.COFW);
        basket.addItem(bagel1.SKU);
        basket.addItem(bagel2.SKU);
        basket.addItem(coffee.SKU);
        float totalPrice = bagel1.getPrice() + bagel2.getPrice() + coffee.getPrice();
        Assertions.assertEquals(totalPrice, basket.calculateCost());
    }
}
