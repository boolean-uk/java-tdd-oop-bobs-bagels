package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class TestCoffee {

    @Test
    public void testCoffee(){
        Coffee testcoffee = new Coffee(3.14, "TEST", "TestCoffee", CoffeeType.Black );
    }
}
