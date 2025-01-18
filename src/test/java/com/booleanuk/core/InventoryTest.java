package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testAddStockItem(){
        Inventory inventory  = new Inventory();
        inventory.addStockItem("BGLP", 1);
        inventory.addStockItem("FILE", 3);
        Assertions.assertEquals(2, inventory.getStockSize());
        Assertions.assertEquals(3, inventory.getItemStock("FILE"));
        Assertions.assertEquals(1, inventory.getItemStock("BGLP"));
    }

    @Test
    public void testRemoveStockItem(){
        Inventory inventory = new Inventory();
        inventory.addStockItem("BGLP", 3);
        inventory.addStockItem("FILE", 1);
        Assertions.assertEquals(2, inventory.getStockSize());

        inventory.removeStockItem("FILE", 1);
        inventory.removeStockItem("BGLP", 2);
        Assertions.assertEquals(1, inventory.getStockSize());
        Assertions.assertEquals(1, inventory.getItemStock("BGLP"));
    }
    
}
