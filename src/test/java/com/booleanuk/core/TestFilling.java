package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFilling {

    @Test
    public void testGetPrice(){
        Filling newFilling = new Filling("Egg", 0.12);

        Assertions.assertEquals(0.12, newFilling.getPrice());
    }

    @Test void testGetType(){
        Filling newFilling = new Filling("Egg", 0.12);

        Assertions.assertEquals("Egg", newFilling.getVariant());
    }

}
