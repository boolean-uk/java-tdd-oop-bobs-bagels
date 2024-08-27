package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    public void createCoffeeTest(){
        Coffee coffee = new Coffee("Latte", 1.29, "COFL");
        Assertions.assertEquals("Latte", coffee.getName());
        Assertions.assertEquals(1.29, coffee.getPrice());
    }

}
