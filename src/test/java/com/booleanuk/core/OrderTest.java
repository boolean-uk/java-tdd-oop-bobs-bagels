package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {


    @Test
    public void isBagelInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("BGLO", "Bagel", "Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isBagelNotInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("RATT", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result);

    }

    @Test
    public void isItemRemovable() {
        Order basket1 = new Order();


        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        boolean result = basket1.remove("BGLO", "Bagel", "Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isItemNotRemovable() {
        Order basket1 = new Order();

        boolean result = basket1.remove("RATT", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result);

    }

    @Test
    public void basketIsFull() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        boolean result = basket1.isBasketFull();
        Assertions.assertTrue(result);

    }


    @Test
    public void basketIsNotFull() {
        Order basket1 = new Order();

        boolean result = basket1.isBasketFull();
        Assertions.assertFalse(result);

    }

    @Test
    public void hasListBeenUpdated() {
        Order basket1 = new Order();

        int result = basket1.updateBasket(30);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void testItemCanBeRemoved() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        String result = basket1.canItemBeRemoved("Onion");
        Assertions.assertEquals("The item can be removed.", result);
    }

    @Test
    public void testItemCannotBeRemoved() {
        Order basket1 = new Order();

        String result = basket1.canItemBeRemoved("Fried");
        Assertions.assertEquals("The item is not in the basket!", result);

    }

    @Test
    public void testTotalCostCorrect() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLP", "Bagel", "Plain", 0.39);
        double result = basket1.totalCost();
        Assertions.assertEquals(0.88, result);
    }

    @Test
    public void testTotalCostWrong() {
        Order basket1 = new Order();

        double result = basket1.totalCost();
        Assertions.assertEquals(0, result);

    }

    @Test
    public void testGetCost() {
        Order basket1 = new Order();

        double result = basket1.getCost("Onion");
        double result2 = basket1.getCost("Plain");
        double result3 = basket1.getCost("Everything");
        Assertions.assertEquals(0.49, result);
        Assertions.assertEquals(0.39, result2);
        Assertions.assertEquals(0.49, result3);

    }

    @Test
    public void isFillingInventory() {
        Order basket1 = new Order();

        boolean result1 = basket1.chooseFilling("FILB", "Filling", "Bacon", 0.12);
        boolean result2 = basket1.chooseFilling("FILE", "Filling", "Egg", 0.12);
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    public void isFillingNotInventory() {
        Order basket1 = new Order();

        boolean result1 = basket1.chooseFilling("RATT", "ggg", "ddd", 0.3);
        boolean result2 = basket1.chooseFilling("RATP", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);

    }

    @Test
    public void testGetCostFilling() {
        Order basket1 = new Order();

        double result = basket1.getFillingCost("Bacon");
        double result2 = basket1.getFillingCost("Egg");
        double result3 = basket1.getFillingCost("Ham");
        Assertions.assertEquals(0.12, result);
        Assertions.assertEquals(0.12, result2);
        Assertions.assertEquals(0.12, result3);

    }




}
