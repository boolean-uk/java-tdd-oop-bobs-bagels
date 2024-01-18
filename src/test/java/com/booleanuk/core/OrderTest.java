package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {


    @Test
    public void isItemInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("BGLO", "Bagel", "Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isItemNotInventory() {
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


}
