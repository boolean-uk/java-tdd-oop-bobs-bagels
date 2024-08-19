package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void createCoffeeTest() {
        Coffee coffee = new Coffee("COFB");

        Assertions.assertEquals("Black", coffee.getName());

    }
}
