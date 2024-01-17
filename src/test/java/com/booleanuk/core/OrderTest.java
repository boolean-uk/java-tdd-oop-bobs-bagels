package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {


    @Test
    public void isItemInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isItemNotInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("Regular", 2.34);
        Assertions.assertFalse(result);

    }


}
