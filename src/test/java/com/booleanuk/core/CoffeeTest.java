package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    public CoffeeTest() {

    }

    @Test
    public void testCreateAllCoffeeSorts() {
        Coffee black = new BlackCoffee();
        Coffee white = new BlackCoffee();
        Coffee capuccino = new BlackCoffee();
        Coffee late = new BlackCoffee();

        Assertions.assertEquals("COFB", black.getSKU());
        Assertions.assertEquals("COFW", white.getSKU());
        Assertions.assertEquals("COFC", capuccino.getSKU());
        Assertions.assertEquals("COFL", late.getSKU());
    }

}
