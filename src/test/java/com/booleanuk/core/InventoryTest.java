package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {
    @Test
    public void getStockTest() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0, inventory.getStock().size());
    }

    @Test
    public void addStockTest() {
        Inventory inventory = new Inventory();
        Product product1 = new Product("Leaf", 0.01);
        Product product2 = new Product("Twig", 0.02);
        inventory.addStock(product1);
        inventory.addStock(product2);
        ArrayList<Product> stock = inventory.getStock();

        Assertions.assertTrue(stock.contains(product1));
        Assertions.assertTrue(stock.contains(product2));
    }

    @Test
    public void removeStockTest() {
        Inventory inventory = new Inventory();
        Product product1 = new Product("Leaf", 0.01);
        Product product2 = new Product("Twig", 0.02);
        inventory.addStock(product1);
        inventory.addStock(product2);

        inventory.removeStock(product1);

        ArrayList<Product> stock = inventory.getStock();

        Assertions.assertFalse(stock.contains(product1));
        Assertions.assertTrue(stock.contains(product2));

    }
}
