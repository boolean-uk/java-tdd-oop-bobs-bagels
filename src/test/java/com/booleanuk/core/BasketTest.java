package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BasketTest {

    private Basket basket;
    private Bagel bagel1;
    private Bagel bagel2;
    private HashMap<String, Filling> fillingsInventory;

    @BeforeEach
    public void setUp() {
        basket = new Basket(2);

        // Create bagel instances
        bagel1 = new Bagel("Plain", 0.49);
        bagel2 = new Bagel("Onion", 0.49);

        // Create a fillings inventory
        fillingsInventory = new HashMap<>();
        fillingsInventory.put("Egg", new Filling("Egg", 0.12));
        fillingsInventory.put("Ham", new Filling("Ham", 0.12));
    }

    @Test
    public void testAddBagel() {
        Assertions.assertEquals("Bagel added to the basket", basket.addBagel(bagel1));
        Assertions.assertEquals("Bagel added to the basket", basket.addBagel(bagel2));
        Assertions.assertEquals("Bagel is already in the basket", basket.addBagel(bagel1));
    }

    @Test
    public void testRemoveBagel() {
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);

        Assertions.assertEquals("Removed from the basket", basket.removeBagel(bagel1));
        Assertions.assertEquals("This bagel does not exist in the basket", basket.removeBagel(bagel1));
    }


    @Test
    public void testIsBasketFull() {
        Assertions.assertFalse(basket.isBasketFull());
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        Assertions.assertTrue(basket.isBasketFull());
    }

    @Test
    public void testSetCapacity() {
        Assertions.assertEquals("Capacity changed", basket.setCapacity(3));
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        basket.addBagel(bagel1);
        Assertions.assertTrue(basket.isBasketFull());
    }

    @Test
    public void testGetTotalCost() {
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);

        Assertions.assertEquals(0.98, basket.getTotalCost(fillingsInventory));
    }

}
