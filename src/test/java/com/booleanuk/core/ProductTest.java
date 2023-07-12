package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private Product coffee;
    private static final String SKU = "BGLO";
    private static final double PRICE = 0.49;
    private static final String VARIANT = "Onion";

    @BeforeEach
    public void setUp() {
        coffee = new Coffee(SKU, PRICE, VARIANT);
    }

    @Test
    public void testGetSKU(){
        Assertions.assertEquals(SKU, coffee.getSKU());
    }

    @Test
    public void testGetPrice(){
        Assertions.assertEquals(PRICE, coffee.getPrice());
    }

    @Test
    public void testGetVariant(){
        Assertions.assertEquals(VARIANT, coffee.getVariant());
    }
}
