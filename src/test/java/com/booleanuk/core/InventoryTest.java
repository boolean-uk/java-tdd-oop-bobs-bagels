package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        Assertions.assertNotNull(inventory.getProduct("BGLO"));
    }

    @Test
    public void testInventoryContents() {
        Inventory inventory = new Inventory();

        assertProduct(inventory, "BGLO", 49, "Onion Bagel");
        assertProduct(inventory, "BGLP", 39, "Plain Bagel");
        assertProduct(inventory, "BGLE", 49, "Everything Bagel");
        assertProduct(inventory, "BGLS", 49, "Sesame Bagel");
        assertProduct(inventory, "COFB", 99, "Black Coffee");
        assertProduct(inventory, "COFW", 119, "White Coffee");
        assertProduct(inventory, "COFC", 129, "Cappuccino");
        assertProduct(inventory, "COFL", 129, "Latte");
        assertProduct(inventory, "FILB", 12, "Bacon");
        assertProduct(inventory, "FILE", 12, "Egg");
        assertProduct(inventory, "FILC", 12, "Cheese");
        assertProduct(inventory, "FILX", 12, "Cream Cheese");
        assertProduct(inventory, "FILS", 12, "Smoked Salmon");
        assertProduct(inventory, "FILH", 12, "Ham");
    }

    private void assertProduct(Inventory inventory, String sku, int price, String variant) {
        Product product = inventory.getProduct(sku);
        Assertions.assertNotNull(product, "Product with SKU " + sku + " should not be null");
        Assertions.assertEquals(price, product.getPrice(), "Price for SKU " + sku + " should be " + price);
        Assertions.assertEquals(variant, product.getVariant(), "Variant for SKU " + sku + " should be " + variant);
    }

    @Test
    public void testGetProductNotObject() {
        Inventory inventory = new Inventory();
        Product product1 = inventory.getProduct("BGLO");
        Product product2 = inventory.getProduct("BGLO");

        Assertions.assertNotSame(product1, product2);
    }

    @Test
    public void testGetProductInvalidValues() {
        Inventory inventory = new Inventory();
        Assertions.assertThrows(IllegalArgumentException.class, () -> inventory.getProduct(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inventory.getProduct(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inventory.getProduct("INVALID"));
    }
}