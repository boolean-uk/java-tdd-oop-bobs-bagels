package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBagel {

    @Test
    public void testBagelConstr(){
        Bagel b = new Bagel(BagelType.Everything);
    }


    @Test
    public void testAddFilling(){
        Bagel b = new Bagel(BagelType.Everything);

        Assertions.assertEquals(b.getFillings(), new ArrayList<>());

        b.addFilling(FillingType.Cream_Cheese);

        Assertions.assertFalse(b.getFillings().isEmpty());

        // check that the correct filling was added to list
        Filling testFilling = new Filling(FillingType.Cream_Cheese);
        ArrayList<Filling> testIterable = new ArrayList<>();
        testIterable.add(testFilling);

        String expectedString = testFilling.toString();
        Assertions.assertEquals(expectedString, b.getFillings().get(0).toString());

    }
}
