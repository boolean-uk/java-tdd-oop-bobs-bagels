package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void getBasketItemsTest() {
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.GetBasketItems().size());
    }

    @Test
    public void addProductTest() {
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.GetBasketItems().size());
        basket.addProduct(new Product("Apple", 0.19));
        Assertions.assertEquals(1, basket.GetBasketItems().size());
        Assertions.assertEquals("Apple", basket.getBasketItems().get(0).getVariant());
        Assertions.assertEquals(0.19, basket.getBasketItems().get(0).getPrice());
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
