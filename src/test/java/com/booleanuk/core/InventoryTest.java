package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void checkPriceTest() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0.39F, inventory.checkPrice("BGLP"));
    }

    @Test
    public void checkPriceTest2() {
        Inventory inventory = new Inventory();
        Assertions.assertNotEquals(0.6F, inventory.checkPrice("BGLP"));
    }

    @Test
    public void checkPriceTest3() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(-1, inventory.checkPrice("OOLL"));
    }
}
