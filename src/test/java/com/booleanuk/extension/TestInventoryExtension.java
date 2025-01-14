package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInventoryExtension {
    @Test    
    void testCheckStock() {
        Inventory inventory = new Inventory();
        inventory.addStock(SKU.FILB, 1);
        
        Assertions.assertTrue(inventory.checkStock(SKU.FILB));
    }

    @Test    
    void addStockValidAmount() {
        Inventory inventory = new Inventory();
        
        Assertions.assertTrue(inventory.addStock(SKU.FILB, 1));
        Assertions.assertTrue(inventory.checkStock(SKU.FILB));
    }

    @Test    
    void addStockInvalidAmount() {
        Inventory inventory = new Inventory();
        
        Assertions.assertFalse(inventory.addStock(SKU.FILB, 0));
        Assertions.assertFalse(inventory.addStock(SKU.FILB, -1));
        Assertions.assertFalse(inventory.checkStock(SKU.FILB));
    }

    @Test
    void removeStockItemInStock() {
        Inventory inventory = new Inventory();
        
        inventory.addStock(SKU.COFB, 10);
        inventory.addStock(SKU.BGLE, 5);

        Assertions.assertTrue(inventory.removeStock(SKU.COFB, 5));
        Assertions.assertTrue(inventory.removeStock(SKU.BGLE, 5));
        Assertions.assertFalse(inventory.checkStock(SKU.BGLE));
    }

    @Test
    void removeStockItemNotInStock() {
        Inventory inventory = new Inventory();

        Assertions.assertFalse(inventory.removeStock(SKU.COFB, 5));
        Assertions.assertFalse(inventory.removeStock(SKU.COFB, 8));
        Assertions.assertFalse(inventory.checkStock(SKU.COFB));
    }
}
