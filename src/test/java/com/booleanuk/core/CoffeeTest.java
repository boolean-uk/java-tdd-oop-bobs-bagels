package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    @Test
    public void testCoffeeCreation(){
        String SKU = "COFB";
        double price = 0.99;
        String name = "Coffee";
        String variant = "Black";
        Coffee coffee = new Coffee(SKU, price, name, variant);

        Assertions.assertEquals(SKU, coffee.getSKU());
        Assertions.assertEquals(price, coffee.getPrice());
        Assertions.assertEquals(name, coffee.getName());
        Assertions.assertEquals(variant, coffee.getVariant());
    }
}
