package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class ProductTest {
    private Product coffee;
    private Product bagel;
    private Product filling;
    private static final String SKU = "BGLO";
    private static final double PRICE = 0.49;
    private static final String VARIANT = "Onion";

    @BeforeEach
    public void setUp() {
        coffee = new Coffee(SKU, PRICE, VARIANT);
        bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());
        filling = new Filling("FILB", 0.12, "Bacon");
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

    @Test
    public void equalsTestShouldReturnTrue() {
        Product bagel1 = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());
        Product filling1 = new Filling("FILB", 0.12, "Bacon");
        Product coffee1 = new Coffee(SKU, PRICE, VARIANT);

        Assertions.assertEquals(bagel, bagel1);
        Assertions.assertEquals(filling, filling1);
        Assertions.assertEquals(coffee, coffee1);
    }

    @Test
    public void equalsTestShouldReturnFalse(){
        Product bagel1 = new Bagel("BGLP", 0.39, "Plain",
                List.of(new Filling("FILE", 0.12, "Egg")));

        Assertions.assertNotEquals(bagel, bagel1);
    }
}
