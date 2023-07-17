package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void getProductBySKUTest_IfSKUExists() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product productFromGetProductBySKU = inventory.getProductBySKU("BGLO");

        Assertions.assertEquals(productFromGetProductBySKU.getSku(), product1.getSku());
        Assertions.assertEquals(productFromGetProductBySKU.getPrice(), product1.getPrice());
        Assertions.assertEquals(productFromGetProductBySKU.getName(), product1.getName());
        Assertions.assertEquals(productFromGetProductBySKU.getVariant(), product1.getVariant());
    }

    @Test
    public void getProductBySKUTest_IfSKUDoesNotExist() {
        Product productFromGetProductBySKU = inventory.getProductBySKU("B");

        Assertions.assertNull(productFromGetProductBySKU);
    }

    @Test
    public void getProductByNameAndVariantTest_IfProductWithThisNameAndVariantExists() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product productFromGetProductBySKU = inventory.getProductByNameAndVariant("Bagel", "Onion");

        Assertions.assertEquals(productFromGetProductBySKU.getSku(), product1.getSku());
        Assertions.assertEquals(productFromGetProductBySKU.getPrice(), product1.getPrice());
        Assertions.assertEquals(productFromGetProductBySKU.getName(), product1.getName());
        Assertions.assertEquals(productFromGetProductBySKU.getVariant(), product1.getVariant());
    }

    @Test
    public void getProductByNameAndVariantTest_IfProductWithThisNameAndVariantDoNotExist() {
        Product productFromGetProductBySKU = inventory.getProductByNameAndVariant("Bag", "Onion");

        Assertions.assertNull(productFromGetProductBySKU);
    }

    @Test
    public void getPriceBySKUTest_IfSKUExists() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        double price = inventory.getPriceBySKU("BGLO");

        Assertions.assertEquals(price, product1.getPrice());
    }

    @Test
    public void getPriceBySKUTest_IfSKUDoesNotExist() {
        double price = inventory.getPriceBySKU("BG");

        Assertions.assertEquals(price, 0.0);
    }


    @Test
    public void getPriceByNameAndVariantTest_IfProductWithThisNameAndVariantExist() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        double price = inventory.getPriceByNameAndVariant("Bagel", "Onion");

        Assertions.assertEquals(price, product1.getPrice());
    }

    @Test
    public void getPriceByNameAndVariantTest_IfProductWithThisNameAndVariantDoNotExist() {
        double price = inventory.getPriceByNameAndVariant("Bagel", "On");

        Assertions.assertEquals(price, 0.0);
    }

    @Test
    public void getPriceByProductTest_IfProductExists() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        double price = inventory.getPriceByProduct(product1);

        Assertions.assertEquals(price, 0.49);
    }

    @Test
    public void getPriceByProductTest_IfProductDoesNotExist() {
        Product product1 = new Product("B", 0.49, "B", "Onion");
        double price = inventory.getPriceByProduct(product1);

        Assertions.assertEquals(price, 0.0);
    }

    @Test
    public void checkIfProductInInventoryTest_IfProductInInventory() {
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertTrue(inventory.checkIfProductInInventory(product1));
    }

    @Test
    public void checkIfProductInInventoryTest_IfProductNotInInventory() {
        Product product1 = new Product("B", 0.49, "B", "Onion");

        Assertions.assertFalse(inventory.checkIfProductInInventory(product1));
    }

    @Test
    public void checkIfProductInInventoryTest_BySku_IfProductInInventory() {
        Assertions.assertTrue(inventory.checkIfProductInInventory("BGLO"));
    }

    @Test
    public void checkIfProductInInventoryTest_BySku_IfProductNotInInventory() {
        Assertions.assertFalse(inventory.checkIfProductInInventory("B"));
    }
}
