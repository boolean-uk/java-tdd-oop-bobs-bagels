package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class InventoryTest {
    @Test
    public void shouldAddNewProductsToInventory() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        Product bagel = new Bagel("bagel",0.49, "BGL");
        Product coffee = new Coffee("coffee",1.49, "COF");
        Assertions.assertTrue(inventory.addNewProduct(bagel));
        Assertions.assertTrue(inventory.addNewProduct(coffee));
    }

    @Test
    public void shouldNotAddExistingProductsAgain() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        Product bagel1 = new Bagel("bagel",0.49, "BGL");
        Product bagel2 = new Bagel("bagel",0.49, "BGL");
        Assertions.assertTrue(inventory.addNewProduct(bagel1));
        Assertions.assertFalse(inventory.addNewProduct(bagel2));
    }

    @Test
    public void shouldReturnListOfProducts() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        inventory.addNewProduct(bagel);
        Product coffee = new Coffee("Black", 0.99, "COFB");
        inventory.addNewProduct(coffee);
        String expected = "BGLO | 0.49$ | Onion Bagel\nCOFB | 0.99$ | Black Coffee";
        Assertions.assertEquals(expected, inventory.getProductList());
    }

    @Test
    public void shouldGetExistingProductWithCorrectName() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        inventory.addNewProduct(bagel);
        Assertions.assertEquals(bagel.toString(), inventory.getProductByName("Onion Bagel").toString());
    }

    @Test
    public void shouldGetNullForNonExistingProduct() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        Assertions.assertNull(inventory.getProductByName("Black Coffee"));
    }

    @Test
    public void shouldGetProductWhenLoadingToInventory() {
        File skuFile = new File("./SkusOfBaseProducts.txt");
        Inventory inventory = new Inventory(skuFile);
        File productsFile = new File("./FullProductList.txt");
        inventory.loadProducts(productsFile);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Assertions.assertEquals(bagel.toString(), inventory.getProductByName("Onion Bagel").toString());
    }
}
