package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    // addBagel() tests
    @Test
    void addShouldSucceed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket();
        Bagel bagel = new Bagel();

        inventory.bagels.add(bagel);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertTrue(inventory.bagelAvailable(bagel.getType()));

        Assertions.assertTrue(basket.add(bagel));

        Assertions.assertNotEquals(-1, basket.items.indexOf(bagel));
    }
    @Test
    void addShouldFail() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket();
        Bagel bagelA = new Bagel();

        Assertions.assertFalse(inventory.bagelAvailable(bagelA.getType()));

        basket.add(bagelA);

        Assertions.assertEquals(1, Basket.capacity);

        Bagel bagelB = new Bagel();
        Assertions.assertFalse(basket.add(bagelB));

        Assertions.assertEquals(-1, basket.items.indexOf(bagelB));

        Assertions.assertEquals(NOTIFICATION.MAXCAPACITY, basket.notification);
    }
    // removeBagel() tests
    @Test
    void removeShouldSucceed() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel();

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        basket.add(bagel);

        Assertions.assertNotEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertTrue(basket.remove(bagel));

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));
    }
    @Test
    void removeShouldFail() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel();

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertFalse(basket.remove(bagel));

        Assertions.assertEquals(-1, basket.items.indexOf(bagel));

        Assertions.assertEquals(NOTIFICATION.BAGELNOTFOUND, basket.notification);
    }
    // setCapacity() tests
    @Test
    void setCapacityShouldBe2() {
        Basket basket = new Basket();

        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertTrue(Basket.setCapacity(2));

        Assertions.assertEquals(2, Basket.capacity);
    }
    @Test
    void setCapacityShouldNotBeMinus2() {
        Basket basket = new Basket();

        Basket.setCapacity(1);

        Assertions.assertEquals(1, Basket.capacity);

        Assertions.assertFalse(Basket.setCapacity(-2));

        Assertions.assertEquals(1, Basket.capacity);
    }
}
