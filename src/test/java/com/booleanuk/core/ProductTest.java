package com.booleanuk.core;

import com.booleanuk.core.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    public ProductTest() {

    }

    @Test
    public void testProductCreate() {
        Product p = new Product("BGLO", 0.49);

        Assertions.assertEquals(0.49, p.getPrice());
        Assertions.assertEquals("BGLO", p.getSKU());
    }

}
