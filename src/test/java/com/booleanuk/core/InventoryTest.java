package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        Assertions.assertNotNull(inventory.getProduct("BGLO"));
    }
}