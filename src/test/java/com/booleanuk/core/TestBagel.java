package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class TestBagel {

    @Test
    public void testBagelConstr(){
        Bagel b = new Bagel(2.5, "TEST", "TestBagel", BagelType.Everything);
    }
}
