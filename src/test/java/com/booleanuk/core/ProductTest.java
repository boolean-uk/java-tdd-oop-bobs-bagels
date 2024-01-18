package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductTest {
    @Test
    public void testBagelInit(){
        Product item = new Product("Bagel", "Plain", "BGLP", 0.39);
        Assertions.assertEquals("BGLP", item.getSku());
        Assertions.assertEquals("Plain", item.getVariant());
        Assertions.assertEquals(0.39, item.getPrice());
    }
    @Test
    public void testCoffeeInit(){
        Product item = new Product("Coffee", "Black", "COFB", 0.99);
        Assertions.assertEquals("COFB", item.getSku());
        Assertions.assertEquals("Black", item.getVariant());
        Assertions.assertEquals(0.99, item.getPrice());
    }
    @Test
    public void testFillingInit(){
        Product item = new Product("Filling", "Egg", "FILE", 0.12);
        Assertions.assertEquals("FILE", item.getSku());
        Assertions.assertEquals("Egg", item.getVariant());
        Assertions.assertEquals(0.12, item.getPrice());
    }



}
