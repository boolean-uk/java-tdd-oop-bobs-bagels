package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelCoreTest {
    @Test
    public void testAddingAndRemovingItems() {
        ShoppingManager _sm = new ShoppingManager();

        Assertions.assertEquals(Error.OK, _sm.basket.add("BGLP", 8));
        Assertions.assertEquals(Error.INVALID, _sm.basket.add("MIMI", 5));
        Assertions.assertEquals(Error.OK, _sm.basket.add("COFW", 2));
        Assertions.assertEquals(Error.VAL_TOO_LOW, _sm.basket.add("FILB", -1));

        Assertions.assertEquals(Error.OK, _sm.basket.remove("BGLP", 4));
        Assertions.assertEquals(Error.OK, _sm.basket.remove("COFW", -1)); // remove everything
        Assertions.assertEquals(Error.EMPTY, _sm.basket.remove("COFW", -1));
    }

    @Test
    public void testBasketIsFull() {
        ShoppingManager _sm = new ShoppingManager();

        _sm.basket.add("BGLP", 15);
        _sm.basket.add("FILB", 9); // should be full at this point

        Assertions.assertEquals(Error.FULL, _sm.basket.add("COFL", 1));

        _sm.basket.remove("BGLP", 1);

        Assertions.assertEquals(Error.OK, _sm.basket.add("COFL", 1));
    }

    @Test
    public void testAdjustBasketCapacity() {
        ShoppingManager _sm = new ShoppingManager();

        _sm.changeBasketCapacity(32);
        Assertions.assertEquals(32, _sm.basket.getCapacity());
    }

    @Test
    public void testTotalCostCheck() {
        ShoppingManager _sm = new ShoppingManager();

        _sm.basket.add("BGLP", 2);
        _sm.basket.add("FILB", 2);

        Assertions.assertEquals((0.39 + 0.12) * 2.0, _sm.basket.calculateTotalPrice(), 0.001);
    }
}
