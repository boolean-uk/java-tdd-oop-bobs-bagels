package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addBagelCorrectlyTest() {
        Basket basket = new Basket();
        basket.addBagel(new Item("BGLP"));
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertEquals("BGLP", basket.items.get(0));
    }

    @Test
    public void addBagelCorrectlyTest2() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addBagel(new Item("BGLP")));
    }

    @Test
    public void addBagelIncorrectlyTest() {
        Basket basket = new Basket();
        basket.addBagel(new Item("BGLP"));
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertNotEquals("BGLE", basket.items.get(0));
    }

    @Test
    public void addBagelIncorrectlyTest2() {
        Basket basket = new Basket();
        Assertions.assertFalse(basket.addBagel(new Item("COFL")));
    }

    @Test
    public void removeBagelCorrectlyTest() {
        Basket basket = new Basket();
        basket.addBagel(new Item("BGLP"));
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertTrue(basket.removeBagel("BGLP"));
        Assertions.assertEquals(0, basket.items.size());
    }

    @Test
    public void removeBagelIncorrectlyTest() {
        Basket basket = new Basket();
        basket.addBagel(new Item("BGLP"));
        Assertions.assertFalse(basket.removeBagel("BGLE"));
    }

    @Test
    public void removeBagelIncorrectlyTest2() {
        Basket basket = new Basket();
        basket.addBagel(new Item("BGLP"));
        Assertions.assertFalse(basket.removeBagel("COFW"));
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
    public void changeCapacityIncorrectlyTest2() {
        Basket basket = new Basket();
        Item item1 = new Item("BGLP");
        Item item2 = new Item("BGLO");
        Item item3 = new Item("COFW");
        basket.addBagel(item1);
        basket.addBagel(item2);
        basket.addBagel(item3);
        float totalPrice = item1.checkBagelPrice() + item2.checkBagelPrice() + item3.checkBagelPrice();
        Assertions.assertEquals(totalPrice, basket.calculateCost());
    }
}
