package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    @Test
    public void checkCoffeePriceTest() {
        Coffee coffee = new Coffee(SKU.COFB);
        Assertions.assertEquals(0.99F, coffee.getPrice());
    }

    @Test
    public void checkWrongCoffeePriceTest() {
        Coffee coffee = new Coffee(SKU.COFW);
        Assertions.assertNotEquals(0.99F, coffee.getPrice());
    }

    @Test
    public void checkCoffeeNameTest() {
        Coffee coffee = new Coffee(SKU.COFB);
        Assertions.assertEquals("Coffee", coffee.getName());
    }

    @Test
    public void checkWrongCoffeeNameTest() {
        Coffee coffee = new Coffee(SKU.COFB);
        Assertions.assertNotEquals("Bagel", coffee.getName());
    }

    @Test
    public void checkCoffeeVariantTest() {
        Coffee coffee = new Coffee(SKU.COFW);
        Assertions.assertEquals("White", coffee.getVariant());
    }

    @Test
    public void checkWrongCoffeeVariantTest() {
        Coffee coffee = new Coffee(SKU.COFW);
        Assertions.assertNotEquals("Black", coffee.getVariant());
    }
}
