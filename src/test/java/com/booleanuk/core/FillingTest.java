package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    @Test
    public void testFillingCreation(){
        String SKU = "BGLS";
        double price = 0.49;
        String name = "Bagel";
        String variant = "Sesame";
        Filling filling = new Filling(SKU, price, name, variant);

        Assertions.assertEquals(SKU, filling.getSKU());
        Assertions.assertEquals(price, filling.getPrice());
        Assertions.assertEquals(name, filling.getName());
        Assertions.assertEquals(variant, filling.getVariant());
    }
}
