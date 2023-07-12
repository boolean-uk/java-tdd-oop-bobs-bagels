package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testAddFilling(){
        Bagel newBagel = new Bagel("BGLO",0.49,"Onion");
        Assertions.assertEquals(0, newBagel.getFillings().size());
        newBagel.addFilling("FILB");
        Assertions.assertEquals(1, newBagel.getFillings().size());
        Assertions.assertFalse(newBagel.addFilling("FILB"));
        Assertions.assertEquals(1, newBagel.getFillings().size());
    }
}
