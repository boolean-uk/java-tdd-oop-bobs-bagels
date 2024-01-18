package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void testProductConstructor() {
        Product product = new Product("BGLO",0.49,"Bagel","Onion");
        Assertions.assertEquals("BGLO",product.getSku());
        Assertions.assertEquals(0.49,product.getPrice());
        Assertions.assertEquals("Bagel",product.getName());
        Assertions.assertEquals("Onion",product.getVariant());
    }
}