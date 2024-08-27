package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testAddAndRetrieveItem() {
        Inventory inventory = new Inventory();
        Assertions.assertTrue(inventory.isItemAvailable("BGLO"));
        Assertions.assertFalse(inventory.isItemAvailable("Random_SKU"));
    }

    @Test
    public void testGetItem() {
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLO");
        Assertions.assertEquals("BGLO", item.getSku());

    }
}
