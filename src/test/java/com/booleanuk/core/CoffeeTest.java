package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void getSku() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        String result = coffee.getSku();

        Assertions.assertEquals("COFB", result);
    }

    @Test
    public void setSku() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        coffee.setSku("COFW");

        String result = coffee.getSku();

        Assertions.assertEquals("COFW", result);
    }

    @Test
    public void getPrice() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        double result = coffee.getPrice();

        Assertions.assertEquals(0.99, result);
    }

    @Test
    public void setPrice() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        coffee.setPrice(1.09);

        double result = coffee.getPrice();

        Assertions.assertEquals(1.09, result);
    }

    @Test
    public void getVariant() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        String result = coffee.getVariant();

        Assertions.assertEquals("Black", result);
    }

    @Test
    public void setVariant() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        coffee.setVariant("White");

        String result = coffee.getVariant();

        Assertions.assertEquals("White", result);
    }

    @Test
    public void getName() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        String result = coffee.getName();

        Assertions.assertEquals("Coffee", result);
    }

    @Test
    public void setName() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");

        coffee.setName("White Coffee");

        String result = coffee.getName();

        Assertions.assertEquals("White Coffee", result);
    }
}
