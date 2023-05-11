package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    // addBagel() tests
    @Test
    void addBagelShouldSucceed() {
        Basket basket = new Basket();

        Assertions.assertEquals(1, Basket.capacity);

        Bagel bagel = new Bagel();
        Assertions.assertTrue(basket.addBagel(bagel));

        Assertions.assertNotEquals(-1, basket.bagels.indexOf(bagel));
    }
    @Test
    void addBagelShouldFail() {
        Basket basket = new Basket();
        Bagel bagelA = new Bagel();
        basket.addBagel(bagelA);

        Assertions.assertEquals(1, Basket.capacity);

        Bagel bagelB = new Bagel();
        Assertions.assertFalse(basket.addBagel(bagelB));

        Assertions.assertEquals(-1, basket.bagels.indexOf(bagelB));

        Assertions.assertEquals(NOTIFICATION.MAXCAPACITY, basket.notification);
    }
    // removeBagel() tests
    @Test
    void removeBagelShouldSucceed() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel();

        Assertions.assertEquals(-1, basket.bagels.indexOf(bagel));

        basket.addBagel(bagel);

        Assertions.assertNotEquals(-1, basket.bagels.indexOf(bagel));

        Assertions.assertTrue(basket.removeBagel(bagel));

        Assertions.assertEquals(-1, basket.bagels.indexOf(bagel));
    }
    @Test
    void removeBagelShouldFail() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel();

        Assertions.assertEquals(-1, basket.bagels.indexOf(bagel));

        Assertions.assertFalse(basket.removeBagel(bagel));

        Assertions.assertEquals(-1, basket.bagels.indexOf(bagel));

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
