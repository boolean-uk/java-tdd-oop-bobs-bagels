package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void testType () {
        ItemInterface item = new Coffee("Coffee", 0.99, "COFB", "Black");
        Assertions.assertEquals("Coffee", item.getType());
        item.setType("Bagel");
        Assertions.assertEquals("Bagel", item.getType());
    }

    @Test
    public void testPrice () {
        ItemInterface item = new Coffee("Coffee", 0.99, "COFB", "Black");
        Assertions.assertEquals(0.99, item.getPrice());
        item.setPrice(0.50);
        Assertions.assertEquals(0.50, item.getPrice());
    }

    @Test
    public void testSKU () {
        ItemInterface item = new Coffee("Coffee", 0.99, "COFB", "Black");
        Assertions.assertEquals("COFB", item.getSku());
        item.setSku("ABCD");
        Assertions.assertEquals("ABCD", item.getSku());

    }
    @Test
    public void testVariant () {
        ItemInterface item = new Coffee("Coffee", 0.99, "COFB", "Black");
        Assertions.assertEquals("Black", item.getVariant());
        item.setVariant("Chai");
        Assertions.assertEquals("Chai", item.getVariant());
    }


}
