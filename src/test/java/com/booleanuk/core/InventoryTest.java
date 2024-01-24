package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryTest {

    @Test
    void getSku() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getSku();

        Assertions.assertEquals("BGLO", result);
    }

    @Test
    void setSku() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        inventory.setSku("BGLP");

        String result = inventory.getSku();

        Assertions.assertEquals("BGLP", result);
    }

    @Test
    void getPrice() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void setPrice() {
        Inventory inventory = new Inventory("BGLP", 0.39, "Bagel", "Plain");

        inventory.setPrice(0.49);

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void getName() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getName();

        Assertions.assertEquals("Bagel", result);
    }

    @Test
    void setName() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        inventory.setName("Coffee");

        String result = inventory.getName();

        Assertions.assertEquals("Coffee", result);
    }

    @Test
    void getVariant() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getVariant();

        Assertions.assertEquals("Onion", result);
    }

    @Test
    void setVariant() {
        Inventory inventory = new Inventory("BGLP", 0.39, "Bagel", "Plain");

        inventory.setVariant("Onion");

        String result = inventory.getVariant();

        Assertions.assertEquals("Onion", result);
    }
}
