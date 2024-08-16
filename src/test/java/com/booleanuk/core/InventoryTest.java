package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0, inventory.getProduct("SKU"));
    }
}
