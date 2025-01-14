package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class InventoryTest {
    private Inventory inventory;
    private Item itemB;
    private Item itemC;
    private Item itemF;

    @BeforeEach
    public void setUp() {
        HashMap<String, Item> inventoryItems = new HashMap<>() {{
            put("BGLS", itemB);
            put("COFB", itemC);
        }};
        inventory = new Inventory(inventoryItems);
        itemB = new Item("BGLS", 0.49, "Bagel", "Sesame");
        itemC = new Item("COFB", 0.99, "Coffee" , "Black");
    }

    @Test
    public void testPrintInventory() {
        Assertions.assertEquals("BGLS, 0.49, Bagel, Sesame \n COFB, 0.99, Coffee, Black" ,inventory.printInventory());
    }
}
