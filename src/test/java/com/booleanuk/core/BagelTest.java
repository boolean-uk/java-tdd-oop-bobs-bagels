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
        abagel.addBagel("bagel7", 2.0, "bagel","plain");
        abagel.addBagel("bagel8", 2.0, "bagel","plain");
        abagel.addBagel("bagel9", 2.0, "bagel","plain");
        abagel.addBagel("bagel10", 2.0, "bagel","plain");
        abagel.addBagel("bagel11", 2.0, "bagel","plain");
        abagel.addBagel("bagel12", 2.0, "bagel","plain");
        abagel.addBagel("bagel13", 2.0, "bagel","plain");
        abagel.addBagel("bagel14", 2.0, "bagel","plain");
        abagel.addBagel("bagel15", 2.0, "bagel","plain");
        abagel.addBagel("bagel16", 2.0, "bagel","plain");
        abagel.addBagel("bagel17", 2.0, "bagel","plain");
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
        Basket basket = new Basket();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("bagel2", 2.0, "bagel","plain");
        abagel.addBagel("bagel3", 2.0, "bagel","plain");
        abagel.addBagel("bagel4", 2.0, "bagel","plain");
        Assertions.assertEquals(6.0, abagel.totalCost());
    }

    @Test
    public void testAllPrint(){
        Bagel abagel = new Bagel();
        Assertions.assertTrue(abagel.inventoryAllPrint());
    }
    @Test
    public void testChooseFilling(){
        Bagel abagel = new Bagel();
        String bagelType = abagel.chooseFilling("Plain");
        Assertions.assertEquals("BGLP", bagelType);
        bagelType = abagel.chooseFilling("Everything");
        Assertions.assertEquals("BGLE", bagelType);
        bagelType = abagel.chooseFilling("Sesame");
        Assertions.assertEquals("BGLS", bagelType);
    }



}
