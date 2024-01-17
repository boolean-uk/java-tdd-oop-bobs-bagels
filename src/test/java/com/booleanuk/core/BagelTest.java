package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelTest {
    @Test
    public void testAddBagel(){
        Bagel abagel = new Bagel();
        Assertions.assertEquals("bagel1", abagel.addBagel("bagel1"));

    }
    @Test
    public void testRemoveBagel(){
        Bagel abagel = new Bagel();
        abagel.addBagel("bagel1");
        Assertions.assertTrue(abagel.removeBagel("bagel1"));
        Assertions.assertFalse(abagel.removeBagel("bagel2"));
    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testBasketFull(){
        Bagel abagel = new Bagel();
        abagel.addBagel("bagel1");
        abagel.addBagel("bagel2");
        abagel.addBagel("bagel4");
        abagel.addBagel("bagel5");
        System.setOut(new PrintStream(outContent));
        Assertions.assertTrue(abagel.basketFull());
        assertEquals("Basket Full", outContent.toString().trim());


    }


}
