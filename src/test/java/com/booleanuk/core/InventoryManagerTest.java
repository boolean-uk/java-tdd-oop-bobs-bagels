package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {

    @Test
    public void testInitializeInventory() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertNotNull(inv.getInventory());
    }
    @Test
    public void testCostEachFilling() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertNotEquals("", inv.costEachFilling());
    }
}
