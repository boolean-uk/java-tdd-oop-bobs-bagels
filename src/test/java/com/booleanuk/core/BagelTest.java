package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BagelTest {

    private Bagel bagel;
    private HashMap<String, Filling> fillingsInventory;

    @BeforeEach
    public void setUp() {
        bagel = new Bagel("Plain", 0.49);

        fillingsInventory = new HashMap<>();
        fillingsInventory.put("Cream Cheese", new Filling("Cream Cheese", 0.12));
        fillingsInventory.put("Jam", new Filling("Jam", 0.12));
    }

    @Test
    public void testGetTypeAndGetPrice() {
        Assertions.assertEquals("Plain", bagel.getType());
        Assertions.assertEquals(0.49, bagel.getPrice());
    }

    @Test
    public void testAddFilling() {
        boolean added = bagel.addFilling("Cream Cheese", fillingsInventory);
        Assertions.assertTrue(added);
        Assertions.assertEquals(1, bagel.getFillings().size());
    }

    @Test
    public void testAddNonExistentFilling() {
        boolean added = bagel.addFilling("Egg", fillingsInventory);
        Assertions.assertFalse(added);
        Assertions.assertEquals(0, bagel.getFillings().size());
    }

    @Test
    public void calculateBagelsCost() {
        bagel.addFilling("Cream Cheese", fillingsInventory);
        double totalCost = bagel.calculateBagelsCost(fillingsInventory);

        Assertions.assertEquals(0.61, totalCost);
    }

    @Test
    public void testCalculateBagelsCostWithNonExistentFilling() {
        bagel.addFilling("Ham", fillingsInventory);
        double totalCost = bagel.calculateBagelsCost(fillingsInventory);

        Assertions.assertEquals(0.49, totalCost);
    }

}
