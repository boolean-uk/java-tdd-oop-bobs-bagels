package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    private Bagel bagel;
    @BeforeEach
    public void setUp() {
        bagel = new Bagel();
        // Initialize with some inventory items for testing
        bagel.addInventoryItem(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        bagel.addInventoryItem(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
    }

    @Test
    public void testAddInventoryItem() {
        Inventory newItem = new Inventory("BGLS", 0.49, "Bagel", "Sesame");
        bagel.addInventoryItem(newItem);
        Inventory foundItem = bagel.findItemBySKU("BGLS");
        Assertions.assertNotNull(foundItem);
        Assertions.assertEquals("BGLS", foundItem.getSKU());
    }

    @Test
    public void testRemoveInventoryItem() {
        bagel.removeInventoryItem("BGLP");
        Inventory foundItem = bagel.findItemBySKU("BGLP");
        Assertions.assertNull(foundItem);
    }

    @Test
    public void testFindItemBySKU() {
        Inventory foundItem = bagel.findItemBySKU("BGLE");
        Assertions.assertNotNull(foundItem);
        Assertions.assertEquals("BGLE", foundItem.getSKU());
    }
}


