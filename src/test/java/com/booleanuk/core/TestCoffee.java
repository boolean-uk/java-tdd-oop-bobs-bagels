package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class TestCoffee {

    @Test
    public void testCoffee(){
        Coffee testcoffee = new Coffee("TEST", "TestCoffee", CoffeeType.Black );
    }
}
