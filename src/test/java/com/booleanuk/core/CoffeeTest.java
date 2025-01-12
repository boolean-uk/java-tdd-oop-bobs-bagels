package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void testCoffeeCreation() {
        Coffee coffee = new Coffee("COFB", 0.99, "Black");
        Assertions.assertEquals("COFB",coffee.getId());
        Assertions.assertEquals(0.99, coffee.getPrice());
        Assertions.assertEquals("Black", coffee.getDescription());
        Assertions.assertInstanceOf(Coffee.class, coffee);
    }
}
