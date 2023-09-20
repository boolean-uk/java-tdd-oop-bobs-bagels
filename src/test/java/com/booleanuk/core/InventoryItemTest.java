package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryItemTest {

    @Test
public void testSKU() {
        InventoryItem inventoryItem = new Bagel("BGLO", 0.49, "Bagel", "Onion") {
        };

        Assertions.assertEquals("BGLO",inventoryItem.getSKU());
        inventoryItem.setSKU("BGLP");
        Assertions.assertEquals("BGLP", inventoryItem.getSKU());
    }

    @Test
    public void testPrice() {
        InventoryItem inventoryItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals(0.49, inventoryItem.getPrice());
        inventoryItem.setPrice(1.19);
        Assertions.assertEquals(1.19, inventoryItem.getPrice());
    }

    @Test
    public void testName() {
        InventoryItem inventoryItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals("Bagel", inventoryItem.getName());
        inventoryItem.setName("Coffee");
        Assertions.assertEquals("Coffee", inventoryItem.getName());
    }

    @Test
    public void testVariant() {
        InventoryItem inventoryItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals("Onion", inventoryItem.getVariant());
        inventoryItem.setVariant("Plain");
        Assertions.assertEquals("Plain", inventoryItem.getVariant());
    }

    @Test
    public void testGetBagelPrice() {
        InventoryItem bagelItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals(0.49, bagelItem.getPrice());
    }
    @Test
    public void testGetFillingPrice() {
        InventoryItem fillingItem = new BagelFilling("FILH", 0.12, "Filling", "Ham");

        Assertions.assertEquals(0.12, fillingItem.getPrice());
    }

    @Test
    public void testItemInStock() {
        Inventory inventory = new Inventory();
        InventoryItem bagelItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem otherBagelItem = new Bagel("BGLC", 0.52, "Bagel", "Chocolate");

        assertTrue(inventory.getInventoryItem().contains(bagelItem));
        assertFalse(inventory.getInventoryItem().contains(otherBagelItem));
    }
}