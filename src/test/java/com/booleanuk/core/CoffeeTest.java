package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {

    @Test
    public void testGetName(){
        Coffee black = new Coffee("COFB");
        Coffee white = new Coffee("COFW");
        Coffee latte = new Coffee("COFL");

        Assertions.assertEquals("Coffee", black.getName());
        Assertions.assertEquals("Coffee", white.getName());
        Assertions.assertEquals("Coffee", latte.getName());
    }

    @Test
    public void testGetVariant(){
        Coffee black = new Coffee("COFB");
        Coffee white = new Coffee("COFW");
        Coffee latte = new Coffee("COFL");

        Assertions.assertEquals("Black", black.getVariant());
        Assertions.assertEquals("White", white.getVariant());
        Assertions.assertEquals("Latte", latte.getVariant());
    }

    @Test
    public void testGetPrice(){
        Coffee black = new Coffee("COFB");
        Coffee white = new Coffee("COFW");
        Coffee latte = new Coffee("COFL");

        Assertions.assertEquals(0.99, black.getPrice());
        Assertions.assertEquals(1.19, white.getPrice());
        Assertions.assertEquals(1.29, latte.getPrice());
    }
}
