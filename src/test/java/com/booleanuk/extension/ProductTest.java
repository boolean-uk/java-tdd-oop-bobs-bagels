package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void createProductTest() {
        Product product = new Product("BGLP", 39, "Bagel", "Plain");

        assertEquals("BGLP", product.sku());
        assertEquals(39, product.price());
        assertEquals("Bagel", product.name());
        assertEquals("Plain", product.variant());
    }

    @Test
    public void createBagelTest(){
        Bagel bagel = new Bagel("BGLP", 39, "Plain");

        assertEquals("BGLP", bagel.sku());
        assertEquals(39, bagel.price());
        assertEquals("Bagel", bagel.name());
        assertEquals("Plain", bagel.variant());
    }

    @Test
    public void createCoffeeTest(){
        Coffee coffee = new Coffee("COFB", 99,  "Black");

        assertEquals("COFB", coffee.sku());
        assertEquals(99, coffee.price());
        assertEquals("Coffee", coffee.name());
        assertEquals("Black", coffee.variant());
    }

    @Test
    public void createFillingTest(){
        Filling filling = new Filling("FILB", 12,  "Bacon");

        assertEquals("FILB", filling.sku());
        assertEquals(12, filling.price());
        assertEquals("Filling", filling.name());
        assertEquals("Bacon", filling.variant());
    }
}
