package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void testAddBagel(){
        Bagel abagel = new Bagel();
        Assertions.assertEquals("bagel1", abagel.addBagel("bagel1"));

    }
    @Test
    public void testRemoveBagel(){
        Bagel abagel = new Bagel();
        Assertions.assertTrue(abagel.removeBagel("bagel1"));
        Assertions.assertFalse(abagel.removeBagel("bagel2"));
    }


}
