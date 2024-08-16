package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testCreateProduct() {
        Product product = new Product("SKU", 10, "Variant");
        Assertions.assertNotNull(product);
    }
}
