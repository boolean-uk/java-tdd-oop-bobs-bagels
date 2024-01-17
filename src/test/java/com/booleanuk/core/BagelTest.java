package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void testAddBagel(){
        Bagel abagel = new Bagel();
        Assertions.assertEquals("bagel1", abagel.addBagel("bagel1"));

    }
}
