package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {

    @Test
    public void testInitializeInventory() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertNotNull(inv.getInventory());
        Assertions.assertTrue(inv.getInventory().containsKey("BGLO"));
        Assertions.assertFalse(inv.getInventory().containsKey("FILL"));
        Assertions.assertFalse(inv.getInventory().containsValue(null));
    }
    @Test
    public void testCostEachFilling() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertNotEquals("", inv.costEachFilling());
    }
}
