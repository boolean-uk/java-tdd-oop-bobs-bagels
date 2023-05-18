package com.booleanuk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCoffee {

    @Test
    public void testGetPrice(){
        Coffee newCoffee = new Coffee("White", 1.19) ;

        Assertions.assertEquals(1.19, newCoffee.getPrice());
    }

    @Test void testGetType(){
        Coffee newCoffee = new Coffee("White", 1.19) ;

        Assertions.assertEquals("White", newCoffee.getVariant());
    }
}
