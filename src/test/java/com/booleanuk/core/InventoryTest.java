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
        Inventory inventory = new Inventory("Bagel");

        inventory.setSku("BGLO");

        String result = inventory.getSku();

        Assertions.assertEquals("BGLO", result);
    }

    @Test
    void getPrice() {
        Inventory inventory = new Inventory("BGLO", 0.49, "Bagel", "Onion");

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void setPrice() {
        Inventory inventory = new Inventory("Bagel");

        inventory.setPrice(0.49);

        double result = inventory.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void getName() {
        Inventory inventory = new Inventory("Bagel");

        String result = inventory.getName();

        Assertions.assertEquals("Bagel", result);
    }

    @Test
    void setName() {
        Inventory inventory = new Inventory("Bagel");

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
        Inventory inventory = new Inventory("Bagel");

        inventory.setVariant("Onion");

        String result = inventory.getVariant();

        Assertions.assertEquals("Onion", result);
    }
}
