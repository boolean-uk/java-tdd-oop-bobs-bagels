package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testCreateProduct() {
        Product product = new Product("SKU", 10, "Variant");
        Assertions.assertNotNull(product);
        Assertions.assertEquals(10, product.getPrice());
        Assertions.assertEquals("SKU", product.getSKU());

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product(null, 20, "Variant2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("SKU3", -20, "Variant3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("SKU4", 20, null));
    }

    @Test
    public void testGetters() {
        Product product = new Product("SKU", 10, "Variant");
        Assertions.assertEquals(10, product.getPrice());
        Assertions.assertEquals("SKU", product.getSKU());
        Assertions.assertEquals("Variant", product.getVariant());
    }
}
