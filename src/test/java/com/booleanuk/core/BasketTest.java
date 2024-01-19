package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void getBasketItemsTest() {
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.getBasketItems().size());
    }

    @Test
    public void addProductTest1() {
        Basket basket = new Basket();
        Product product = new Product("Apple", 0.19);
        basket.addProduct(product);
        basket.addProduct(product);

        Assertions.assertEquals(2, basket.getBasketItems().size());
        Assertions.assertTrue(basket.getBasketItems().contains(product));
        Assertions.assertEquals(0.19, basket.getBasketItems().get(0));
    }

    @Test
    public void addProductTest2() {
        Basket basket = new Basket();
        Product product = new Product("Apple", 0.19);
        basket.addProduct(product, 2);
        Assertions.assertEquals(2, basket.getBasketItems().size());
        Assertions.assertTrue(basket.getBasketItems().contains(product));
        Assertions.assertEquals(0.19, basket.getBasketItems().get(0));

    }

    @Test
    public void removeProductTest() {

    }

    @Test
    public void getCapacityTest() {

    }

    @Test
    public void setCapacityTest() {

    }

    @Test
    public void isBasketFullTest() {

    }
}
