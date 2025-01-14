package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {
    private Inventory inventory;
    private Item itemB;
    private Item itemC;
    private Item itemF;

    @BeforeEach
    public void setUp() {
        ArrayList<Item> inventoryItems = new ArrayList<>();
        inventory = new Inventory(inventoryItems);
        itemB = new Item("BGLS", 0.49, "Bagel", "Sesame");
        itemC = new Item("COFB", 0.99, "Coffee" , "Black");
        itemF = new Item("FILX", 0.12, "Filling", "Cream Cheese");
    }

    @Test
    public void testHasItem() {
        ArrayList<Item> inventoryItems = new ArrayList<>() {{
            add(itemB);
            add(itemC);
            add(itemF);
        }};
        Assertions.assertTrue(inventoryItems.hasItem(itemF));
    }
}
