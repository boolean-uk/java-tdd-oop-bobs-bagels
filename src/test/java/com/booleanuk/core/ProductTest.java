package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void skuGetterTest() {
        Product product = new Product("BGLO", 0.49, "Bagel", "Onion");
        String sku = product.getSku();
        Assertions.assertEquals("BGLO", sku);
    }

    @Test
    public void priceGetterTest() {
        Product product = new Product("BGLO", 0.49, "Bagel", "Onion");
        double price = product.getPrice();
        Assertions.assertEquals(0.49, price);
    }

    @Test
    public void nameGetterTest() {
        Product product = new Product("BGLO", 0.49, "Bagel", "Onion");
        String name = product.getName();
        Assertions.assertEquals("Bagel", name);
    }

    @Test
    public void variantGetterTest() {
        Product product = new Product("BGLO", 0.49, "Bagel", "Onion");
        String variant = product.getVariant();
        Assertions.assertEquals("Onion", variant);
    }
}
