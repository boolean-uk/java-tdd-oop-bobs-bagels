package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InventoryTest {

    @Test
    public void testGetInventoryItem() {
        Inventory inventory = new Inventory();
        List<InventoryItem> inventoryItem = inventory.getInventoryItem();

        assertNotNull(inventoryItem);
        assertEquals(14, inventoryItem.size());

    }
}
