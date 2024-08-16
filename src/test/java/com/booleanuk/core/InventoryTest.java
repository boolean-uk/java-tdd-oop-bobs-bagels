package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class InventoryTest {
    @Test
    public void testAddInventoryItem(){
        Inventory inventory = new Inventory();
        InventoryItem item =  new InventoryItem("BGLO",0.49, "Bagel","Onion");
        inventory.addInventoryItem(item);
        HashMap<String, InventoryItem> map = inventory.getInventoryItemHashMap();
        Assertions.assertEquals(map.get("BGLO"), item);

    }

    @Test
    public void testGetInventoryItem(){
        Inventory inventory = new Inventory();
        InventoryItem item =  new InventoryItem("BGLO",0.49, "Bagel","Onion");
        inventory.addInventoryItem(item);
        Assertions.assertEquals(inventory.getInventoryItemDetails("BGLO"), item);

    }
}
