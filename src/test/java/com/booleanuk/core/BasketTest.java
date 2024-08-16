package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {
    @Test
    public void getBasketItemsTest() {
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.getInventory().size());
    }

    @Test
    public void addProductTest1() {
        Basket basket = new Basket();
        Product product1 = new Product("Apple", 0.19);
        Product product2 = new Product("Orange", 0.29);
        basket.addProduct(product1);
        basket.addProduct(product2);

        Assertions.assertEquals(2, basket.getInventory().size());
        Assertions.assertTrue(basket.getInventory().contains(product1));
        Assertions.assertTrue(basket.getInventory().contains(product2));
        Assertions.assertEquals(0.19, basket.getInventory().get(0).getPrice());
        Assertions.assertEquals(0.29, basket.getInventory().get(1).getPrice());
    }

    @Test
    public void addProductTest2() {
        Basket basket = new Basket();
        Product product = new Product("Apple", 0.19);
        basket.addProduct(product, 2);
        Assertions.assertEquals(2, basket.getInventory().size());
        Assertions.assertTrue(basket.getInventory().contains(product));
        Assertions.assertEquals(0.19, basket.getInventory().get(1).getPrice());

    }

    @Test
    public void addProductTest3() {
        Basket basket = new Basket();
        Product product1 = new Product("Apple", 0.19);
        Product product2 = new Product("Orange", 0.29);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        basket.addProduct(products);

        Assertions.assertEquals(2, basket.getInventory().size());
        Assertions.assertTrue(basket.getInventory().contains(product1));
        Assertions.assertTrue(basket.getInventory().contains(product2));
        Assertions.assertEquals(0.19, basket.getInventory().get(0).getPrice());
        Assertions.assertEquals(0.29, basket.getInventory().get(1).getPrice());
    }

    @Test
    public void removeProductTest1() {
        Basket basket = new Basket();
        Product product1 = new Product("Apple", 0.19);
        Product product2 = new Product("Orange", 0.29);

        basket.addProduct(product1);
        basket.addProduct(product2);

        ArrayList<Product> productsTest = new ArrayList<>();
        productsTest.add(new Product("Orange", 0.29));

        basket.removeProduct(product1);

        Assertions.assertEquals(1, basket.getInventory().size());
        Assertions.assertIterableEquals(productsTest, basket.getInventory());


    }

    @Test
    public void removeProductTest2() {
        Basket basket = new Basket();
        Product product1 = new Product("Apple", 0.19);
        Product product2 = new Product("Orange", 0.29);

        basket.addProduct(product1);
        basket.addProduct(product2);

        ArrayList<Product> productsTest = new ArrayList<>();
        productsTest.add(new Product("Orange", 0.29));
        basket.removeProduct("Apple");

        Assertions.assertEquals(productsTest, basket.getInventory());
        Assertions.assertEquals(1, basket.getInventory().size());


    }

    @Test
    public void getCapacityTest() {
        Basket basket = new Basket(3);
        Assertions.assertEquals(3, basket.getCapacity());
    }

    @Test
    public void setCapacityTest() {
        Basket basket = new Basket(3);
        basket.setCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void isBasketFullTest() {
        Basket basket = new Basket(2);
        Product product1 = new Product("Apple", 0.19);
        Product product2 = new Product("Orange", 0.29);

        Assertions.assertFalse(basket.isBasketFull());
        basket.addProduct(product1);
        basket.addProduct(product2);
        Assertions.assertTrue(basket.isBasketFull());

    }
}
