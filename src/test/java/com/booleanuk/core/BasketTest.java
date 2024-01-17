package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
    @Test
    public void addingBagelToBasketReturnsTrue() {
        Basket basket = new Basket();

        Bagel newBagel = new Bagel("Plain bagel", 2.49);

        Assertions.assertTrue(basket.add(newBagel));
    }

    @Test
    public void removingBagelToBasketReturnsTrue() {
        Basket basket = new Basket();

        Bagel newBagel = new Bagel("Plain bagel", 2.49);

        basket.add(newBagel);

        Assertions.assertTrue(basket.remove(newBagel));
    }

    @Test
    public void returnsTrueIfBasketIsFull() {
        Basket basket = new Basket();

        Bagel plainBagel = new Bagel("Plain bagel", 2.49);
        Bagel eggBagel = new Bagel("Egg bagel", 2.69);
        Bagel sourdoughBagel = new Bagel("Sourdough bagel", 2.69);

        basket.add(plainBagel);
        Assertions.assertFalse(basket.isFull());

        basket.add(eggBagel);
        Assertions.assertTrue(basket.isFull());

        basket.add(sourdoughBagel);
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    public void testExpandingBasketCapacity() {
        Basket basket = new Basket();

        Assertions.assertEquals(2, basket.getCapacity());

        basket.modifyCapacity(5);

        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void testRemovingNonExistentItem() {
        Basket basket = new Basket();

        Bagel newBagel = new Bagel("Plain bagel", 2.49);

        basket.add(newBagel);

        Bagel oldBagel = new Bagel("Egg bagel", 2.69);

        Assertions.assertFalse(basket.remove(oldBagel));
    }

    @Test
    public void returnsTrueIfCostOfBasketIsSameAsExpected() {
        Basket basket = new Basket();

        Bagel plainBagel = new Bagel("Plain bagel", 2.49);

        basket.add(plainBagel);

        Assertions.assertEquals(2.49, basket.totalCost());
    }

    @Test
    public void returnsCorrectCostOfBagel() {
        Bagel plainBagel = new Bagel("Plain", 2.49); //As a shop owner I introduce a new product and set its price
        Bagel eggBagel = new Bagel("Egg", 2.69); //As a shop owner I introduce a new product and set its price
        Bagel sourdoughBagel = new Bagel("Sourdough", 2.69);

        double plainBagelPrice = plainBagel.getPrice(); //As a customer I can access the bagels and return their price
        double eggBagelPrice = eggBagel.getPrice(); //As a customer I can access the bagels and return their price
        String sourdoughBagelPrice = sourdoughBagel.getBagelPrice();

        Assertions.assertEquals("This bagel costs 2.69", sourdoughBagelPrice);
    }
}
