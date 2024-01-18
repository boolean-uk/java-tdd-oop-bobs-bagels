package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void getPrice() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals(0.39, product.getPrice());

    }

    @Test
    public void getVariant() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("apple", product.getVariant());
    }

    @Test
    public void getName() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("Other", product.getName());
    }

    @Test
    public void getSku() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("OTHA", product.getSku());
    }

}
