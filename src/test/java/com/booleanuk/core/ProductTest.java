package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void shouldGetType() {
        Product bagel = new Bagel("bagel",0.49, "BAG");
        Product coffee = new Coffee("coffee",1.49, "COF");
        Assertions.assertEquals("bagel", bagel.getType());
        Assertions.assertEquals("coffee", coffee.getType());
    }

    @Test
    public void shouldGetCost() {
        Product bagel = new Bagel("bagel",0.49, "BAG");
        Product coffee = new Coffee("coffee",1.49, "COF");
        Assertions.assertEquals(0.49, bagel.getCost());
        Assertions.assertEquals(1.49, coffee.getCost());
    }

    @Test
    public void shouldGetSKU() {
        Product bagel = new Bagel("bagel",0.49, "BAG");
        Product coffee = new Coffee("coffee",1.49, "COF");
        Assertions.assertEquals("BAG", bagel.getSku());
        Assertions.assertEquals("COF", coffee.getSku());
    }
}
