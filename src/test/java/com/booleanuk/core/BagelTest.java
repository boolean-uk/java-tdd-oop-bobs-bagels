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
        Assertions.assertEquals("bagel1", abagel.addBagel("bagel1", 2.0, "bagel","plain"));

    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testBasketFull(){
        Bagel abagel = new Bagel();
        abagel.addBagel("bagel1", 2.0, "bagel","plain");
        abagel.addBagel("bagel2", 2.0, "bagel","plain");
        abagel.addBagel("bagel3", 2.0, "bagel","plain");
        abagel.addBagel("bagel4", 2.0, "bagel","plain");
        abagel.addBagel("bagel5", 2.0, "bagel","plain");
        abagel.addBagel("bagel6", 2.0, "bagel","plain");
        System.setOut(new PrintStream(outContent));
        Assertions.assertTrue(abagel.basketFull());
        assertEquals("Basket Full", outContent.toString().trim());
    }

    @Test
    public void testChangeCap(){
        Bagel abagel = new Bagel();
        int outcome = abagel.changeCap(3);
        Assertions.assertEquals(3,outcome);
    }
    @Test
    public void testRemoveBagel(){
        Bagel abagel = new Bagel();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("bagel1", 2.0, "bagel","plain");
        Assertions.assertTrue(abagel.removeBagel("bagel1"));
        Assertions.assertFalse(abagel.removeBagel("bagel2"));
        assertEquals("Basket does not contain this bagel2", outContent.toString().trim());
    }

    @Test
    public void testTotalCost(){
        Bagel abagel = new Bagel();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("bagel1", 2.0, "bagel","plain");
        abagel.addBagel("bagel2", 2.0, "bagel","plain");
        abagel.addBagel("bagel3", 2.0, "bagel","plain");
        abagel.addBagel("bagel4", 2.0, "bagel","plain");
        Assertions.assertEquals(8.0, abagel.totalCost());
        assertEquals("Basket does not contain this bagel2", outContent.toString().trim());
    }



}
