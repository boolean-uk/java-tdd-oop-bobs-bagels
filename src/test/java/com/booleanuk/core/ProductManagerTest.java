package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager productManager;

    @BeforeEach
    public void initializeTest() {
        productManager = new ProductManager();
    }

    @Test
    public void shouldAddBagelToBasket() {
        //Execute
        boolean result = productManager.orderBagel("Plain");

        //Verify
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotAddBagelToBasket() {
        //Execute
        boolean result = productManager.orderBagel("Fake");

        //Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldRemoveBagelFromBasket() {
        //Setup
        productManager.orderBagel("Plain");


        //Execute
        boolean result = productManager.removeBagel("Plain");

        //Verify

        Assertions.assertEquals(0,productManager.getBasket().getList().size());
    }

    @Test
    public void shouldNotRemoveFromBasket() {
        //Execute
        boolean result = productManager.removeBagel("Plain");

        //Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void fillHashMapFromFileTest() {
        // Assert that getInventory() method works and fills HashMap
        Assertions.assertFalse(productManager.getInventory().isEmpty());

        // Assert hard-coded for the inventory.txt file, remove for custom use
        Assertions.assertEquals("Onion", productManager.getInventory().get("BGLO").getVariant());
    }
}
