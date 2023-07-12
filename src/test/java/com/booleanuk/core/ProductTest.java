package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private Product bagel;
    private static final String SKU = "BGLO";
    private static final double PRICE = 0.49;
    private static final String VARIANT = "Onion";

    @BeforeEach
    public void setUp() {
        bagel = new Bagel(SKU, PRICE, VARIANT);
    }

    @Test
    public void testGetSKU(){
        Assertions.assertEquals(SKU, bagel.getSKU());
    }

    @Test
    public void testGetPrice(){
        Assertions.assertEquals(PRICE, bagel.getPrice());
    }

    @Test
    public void testGetVariant(){
        Assertions.assertEquals(VARIANT, bagel.getVariant());
    }
}
