package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void testProductConstructor() {
        Product product = new Product("BGLO",0.49,"Bagel","Onion");
        Assertions.assertEquals("BGLO",product.sku);
        Assertions.assertEquals(0.49,product.price);
        Assertions.assertEquals("Bagel",product.name);
        Assertions.assertEquals("Onion",product.variant);
    }
}