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
        Assertions.assertEquals("BGLO", abagel.addBagel("BGLO"));

    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testBasketFull(){
        Bagel abagel = new Bagel();
        abagel.changeCap(15);
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");

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
        abagel.addBagel("BGLO");
        Assertions.assertTrue(abagel.removeBagel("BGLO"));
        //Assertions.assertFalse(abagel.removeBagel("BGLO"));
        //assertEquals("Product not found in inventory: BGLO", outContent.toString().trim());
    }

    @Test
    public void testTotalCost(){
        Bagel abagel = new Bagel();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        Assertions.assertEquals(10.43, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(2.45, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(0.98, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(2.49, abagel.totalCost());
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
        bagelType = abagel.chooseFilling("Strawberry");
        Assertions.assertEquals("Error", bagelType);
    }
    @Test
    public void testCostofFilling(){
        Bagel abagel = new Bagel();

        double bagelCost = abagel.costFilling("Plain");
        Assertions.assertEquals(0.39, bagelCost);
        bagelCost = abagel.costFilling("Everything");
        Assertions.assertEquals(0.49, bagelCost);
        bagelCost = abagel.costFilling("Sesame");
        Assertions.assertEquals(0.49, bagelCost);
        bagelCost = abagel.costFilling("Strawberry");
        Assertions.assertEquals(0.0, bagelCost);
    }
    @Test
    public void testIfBagelInStock(){
        Bagel abagel = new Bagel();

        boolean bagelCost = abagel.searchStock("BGLO");
        Assertions.assertTrue( bagelCost);
        bagelCost = abagel.searchStock("BGLS");
        Assertions.assertTrue( bagelCost);
        bagelCost = abagel.searchStock("BGLE");
        }








}
