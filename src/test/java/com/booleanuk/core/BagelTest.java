package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testBagelCreation(){
        String SKU = "BGLS";
        double price = 0.49;
        String name = "Bagel";
        String variant = "Sesame";
        Bagel bagel = new Bagel(SKU, price, name, variant);

        Assertions.assertEquals(SKU, bagel.getSKU());
        Assertions.assertEquals(price, bagel.getPrice());
        Assertions.assertEquals(name, bagel.getName());
        Assertions.assertEquals(variant, bagel.getVariant());
    }
}
