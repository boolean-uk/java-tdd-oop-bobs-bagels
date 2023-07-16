package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void createProductTest() {
        Product product = new Product("BGLP", 39, "Bagel", "Plain");

        assertEquals("BGLP", product.sku());
        assertEquals(39, product.price());
        assertEquals("Bagel", product.name());
        assertEquals("Plain", product.variant());
    }
}
