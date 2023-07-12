package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager productManager;
    @BeforeEach
    public void initializeTest(){
        productManager = new ProductManager();
    }

    @Test
    public void orderBagelSuccess() {

    }

    @Test
    public void orderBagelFail() {

    }

    @Test
    public void removeBagelSuccess() {

    }

    @Test
    public void removeBagelFail() {

    }

    @Test
    public void fillHashMapFromFileTest() {
        // Assert that getInventory() method works and fills HashMap
        Assertions.assertFalse(productManager.getInventory().isEmpty());

        // Assert hard-coded for the inventory.txt file, remove for custom use
        Assertions.assertEquals("Onion", productManager.getInventory().get("BGLO").getVariant());
    }
}
