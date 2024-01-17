package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    @Test
    public void testCreateCoffee(){
        Coffee coffee = new Coffee("black");
        Assertions.assertEquals("black coffee", coffee.getName());
        Assertions.assertEquals("black", coffee.getFlavor());
        Assertions.assertEquals(1.00, coffee.getPrice());
    }
}
