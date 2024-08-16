package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    public ProductTest() {

    }

    @Test
    public void testProductCreate() {
        Product p = new Product("BGLO");

        Assertions.assertEquals("BGLO", p.getSKU());
    }

}
