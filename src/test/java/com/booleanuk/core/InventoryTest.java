package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryTest {

    @Test
    public void getSku() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getSku();

        Assertions.assertEquals("BGLO", result);
    }

    @Test
    public void setSku() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        inventory.setSku("BGLP");

        String result = inventory.getSku();

        Assertions.assertEquals("BGLP", result);
    }

    @Test
    public void getPrice() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    public void setPrice() {
        Inventory inventory = new Inventory("BGLP", 0.39, "Bagel", "Plain");

        inventory.setPrice(0.49);

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    public void getName() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getName();

        Assertions.assertEquals("Bagel", result);
    }

    @Test
    public void setName() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        inventory.setName("Coffee");

        String result = inventory.getName();

        Assertions.assertEquals("Coffee", result);
    }

    @Test
    public void getVariant() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        String result = inventory.getVariant();

        Assertions.assertEquals("Onion", result);
    }

    @Test
    public void setVariant() {
        Inventory inventory = new Inventory("BGLP", 0.39, "Bagel", "Plain");

        inventory.setVariant("Onion");

        String result = inventory.getVariant();

        Assertions.assertEquals("Onion", result);
    }
}
