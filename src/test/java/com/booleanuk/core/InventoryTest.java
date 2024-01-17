package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testHasStockValue(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(30, inventory.bagelInventory.get("BGLO"));
        Assertions.assertEquals(25,inventory.coffeeInventory.get("COFC"));
        Assertions.assertEquals(50, inventory.fillingInventory.get("FILH"));
    }

    @Test
    public void testIfInStock(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(true, inventory.isInStock("BGLO"));
    }

    @Test
    public void testIfNotInStock(){
        Inventory inventory = new Inventory();
        inventory.bagelInventory.put("BGLO", 0);
        Assertions.assertEquals(false, inventory.isInStock("BGLO"));
    }

}
