package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void shouldAddNewProductsToInventory() {
        Inventory inventory = new Inventory();
        Product bagel = new Product("bagel",0.49, "BAG");
        Product coffee = new Product("coffee",1.49, "COF");
        Assertions.assertTrue(inventory.addNewProduct(bagel));
        Assertions.assertTrue(inventory.addNewProduct(coffee));
    }

    @Test
    public void shouldNotAddExistingProductsAgain() {
        Inventory inventory = new Inventory();
        Product bagel1 = new Product("bagel",0.49, "BAG");
        Product bagel2 = new Product("bagel",0.49, "BAG");
        Assertions.assertTrue(inventory.addNewProduct(bagel1));
        Assertions.assertFalse(inventory.addNewProduct(bagel2));
    }

    @Test
    public void shouldReturnListOfProducts() {
        Inventory inventory = new Inventory();
        Product bagel = new Product("Onion",0.49, "BGLON");
        inventory.addNewProduct(bagel);
        String expected = "BGLON | Onion Bagel | 0.49$";
        Assertions.assertEquals(expected, inventory.getProductList());
    }

    @Test
    public void shouldGetExistingProductWithCorrectName() {
        Inventory inventory = new Inventory();
        Product bagel = new Product("Onion",0.49, "BGLON");
        inventory.addNewProduct(bagel);
        Assertions.assertEquals(bagel.toString(), inventory.getProductByName("Onion Bagel").toString());
    }

    @Test
    public void shouldGetNullForNonExistingProduct() {
        Inventory inventory = new Inventory();
        Assertions.assertNull(inventory.getProductByName("Black Coffee"));
    }
}
