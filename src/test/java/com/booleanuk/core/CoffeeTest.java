package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    @Test
    public void testCreateCoffee(){
        Coffee coffee = new Coffee(1.00, "COFB", "Black");
        Assertions.assertEquals("Coffee", coffee.getItemName());
        Assertions.assertEquals("Black", coffee.getVariant());
        Assertions.assertEquals(1.00, coffee.getPrice());
        Assertions.assertEquals("COFB", coffee.getSku());
    }
}
