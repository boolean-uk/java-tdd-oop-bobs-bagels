package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {



    @Test
    public void testInit() {
        Coffee coffee = new Coffee("Black");

        Assertions.assertEquals(0.99, coffee.getPrice());
        Assertions.assertEquals("Coffee", coffee.getName());
    }
}
