package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testAddStockItem(){
        Inventory inventory  = new Inventory();
        inventory.addStockItem("BGLP", 1);
        inventory.addStockItem("FILE", 1);
        Assertions.assertEquals(2, inventory.stock.size());
    }

    @Test
    public void testRemoveStockItem(){
        Inventory inventory = new Inventory();
        inventory.addStockItem("BGLP", 1);
        inventory.addStockItem("FILE", 1);
        Assertions.assertEquals(2, inventory.stock.size());

        inventory.removeStockItem("FILE", 1);
        Assertions.assertEquals(1, inventory.stock.size());
    }

    @Test
    public void testCheckStock(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(1, inventory.checkStock());

    }
}
