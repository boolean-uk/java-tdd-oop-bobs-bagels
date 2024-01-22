package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryExTest {

    @Test
    public void testMapNameTypeToSKU() {
        InventoryEx inventory = new InventoryEx();
        Assertions.assertEquals("FILB", inventory.mapTypeVariantToSKU.get("Filling Bacon"));
        Assertions.assertEquals("COFL", inventory.mapTypeVariantToSKU.get("Coffee Latte"));
        Assertions.assertEquals("BGLE", inventory.mapTypeVariantToSKU.get("Bagel Everything"));
    }

    @Test
    public void testItemsMap() {
        InventoryEx inventory = new InventoryEx();
        Assertions.assertEquals(0.12, inventory.items.get("FILB").getPrice());
        Assertions.assertEquals("Latte", inventory.items.get("COFL").getType());
        Assertions.assertEquals("Bagel", inventory.items.get("BGLE").getName());
    }
}
