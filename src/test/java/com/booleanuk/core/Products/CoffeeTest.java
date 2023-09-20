package com.booleanuk.core.Products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CoffeeTest {

    @Test
    public void testCoffee() {
        Coffee coffee = new Coffee("COFB", new BigDecimal("0.99"), "Coffee", CoffeeType.Black);
        assertEquals("COFB", coffee.getSku());
        assertEquals(BigDecimal.valueOf(0.99), coffee.getPrice());
        assertEquals("Coffee", coffee.getName());
        assertEquals(CoffeeType.Black, coffee.getVariant());
    }

    @Test
    public void testHasDiscount() {
        Coffee coffeeWithDiscount = new Coffee("COFB", new BigDecimal("0.99"), "Coffee", CoffeeType.Black);
        Coffee coffeeWithoutDiscount = new Coffee("COFC", new BigDecimal("1.29"), "Coffee", CoffeeType.Cappuccino);

        assertTrue(coffeeWithDiscount.hasDiscount());
        assertFalse(coffeeWithoutDiscount.hasDiscount());
    }

    @Test
    public void testIsBagelAdded() {
        Coffee coffee = new Coffee("COFB", new BigDecimal("0.99"), "Coffee", CoffeeType.Black);

        assertFalse(coffee.isBagelAdded());

        coffee.setBagelAdded(true);
        assertTrue(coffee.isBagelAdded());

        Coffee coffeeWithDiscount = new Coffee("COFB", new BigDecimal("0.99"), "Coffee", CoffeeType.Black);
        coffeeWithDiscount.setBagelAdded(true);
        assertTrue(coffeeWithDiscount.isBagelAdded());

        Coffee coffeeWithoutDiscount = new Coffee("COFC", new BigDecimal("1.29"), "Coffee", CoffeeType.Cappuccino);
        coffeeWithoutDiscount.setBagelAdded(true);
        assertFalse(coffeeWithoutDiscount.isBagelAdded());
    }

    @Test
    public void testCalculateTotalPriceItem() {
        Coffee coffeeWithDiscount = new Coffee("COFB", new BigDecimal("0.99"), "Coffee", CoffeeType.Black);
        Coffee coffeeWithoutDiscount = new Coffee("COFC", new BigDecimal("1.29"), "Coffee", CoffeeType.Cappuccino);

        assertEquals(BigDecimal.valueOf(0.99), coffeeWithDiscount.calculateTotalPriceItem());

        assertEquals(BigDecimal.valueOf(1.29), coffeeWithoutDiscount.calculateTotalPriceItem());

        coffeeWithDiscount.setBagelAdded(true);
        assertEquals(Coffee.COFFEE_AND_BAGEL_DISCOUNT_PRICE, coffeeWithDiscount.calculateTotalPriceItem());
    }
}
