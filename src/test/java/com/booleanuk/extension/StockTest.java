package com.booleanuk.extension;

import com.booleanuk.core.Product;
import com.booleanuk.core.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StockTest {
    @Test
    public void getStockTest() {
        Stock stock = new Stock();
        Assertions.assertEquals(0, stock.getInventory().size());
    }

    @Test
    public void addStockTest() {
        Stock stock = new Stock();
        Product product1 = new Product("Leaf", 0.01);
        Product product2 = new Product("Twig", 0.02);
        stock.addProduct(product1);
        stock.addProduct(product2);
        ArrayList<Product> products = stock.getInventory();

        Assertions.assertTrue(products.contains(product1));
        Assertions.assertTrue(products.contains(product2));
    }

    @Test
    public void removeStockTest() {
        Stock stock = new Stock();
        Product product1 = new Product("Leaf", 0.01);
        Product product2 = new Product("Twig", 0.02);
        stock.addProduct(product1);
        stock.addProduct(product2);

        stock.removeProduct(product1);

        ArrayList<Product> products = stock.getInventory();

        Assertions.assertFalse(products.contains(product1));
        Assertions.assertTrue(products.contains(product2));

    }

    @Test
    public void inStockTest() {
        Stock stock = new Stock();
        Product product1 = new Product("Leaf", 0.01);
        Product product2 = new Product("Twig", 0.02);
        Product product3 = new Product("Small stone", 0.05);
        stock.addProduct(product1);
        stock.addProduct(product2);

        Assertions.assertTrue(stock.inInventory(product1));
        Assertions.assertTrue(stock.inInventory(product2));
        Assertions.assertFalse(stock.inInventory(product3));

    }
}
