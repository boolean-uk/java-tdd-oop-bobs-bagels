package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    public void testAddRightBagel(){
       Basket basket = new Basket();
       Basket.setMaxSize(1);
       Bagel bagelRight = new Bagel("BGLO", 0.49, "Onion");

       //Add Bagel
       Assertions.assertTrue(basket.add(bagelRight));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add(bagelRight));

    }

    @Test
    public void testAddWrongBagel(){
        Basket basket = new Basket();

        Bagel bagelWrongPrice = new Bagel("BGLO", 0.69, "Onion");
        Bagel bagelWrongVariant = new Bagel("BGLO", 0.39, "Plain");
        Bagel bagelWrongId = new Bagel("BGL", 0.39, "Plain");

        //Add Wrong Bagel
        Assertions.assertFalse(basket.add(bagelWrongPrice));
        Assertions.assertFalse(basket.add(bagelWrongVariant));
        Assertions.assertFalse(basket.add(bagelWrongId));
        Assertions.assertFalse(basket.add(bagelWrongPrice));

    }

    @Test
    public void testRemove(){
        Basket basket = new Basket();
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Onion");
        Bagel bagel2 = new Bagel("BGLO", 0.49, "Onion");
        basket.add(bagel1);

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel2));

        //Remove bagel in basket
        Assertions.assertTrue(basket.remove(bagel1));
    }

    @Test
    public void testAddFillings(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion");
        Bagel bagel2 = new Bagel("BGLO", 0.49, "Onion");
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");
        basket.add(bagel);

        //Add single filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, new Filling[]{filling1}));

        //Add multiple filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, new Filling[]{filling1, filling2}));

        //Add filling to bagel not in basket
        Assertions.assertFalse(basket.addFillings(bagel2, new Filling[]{filling1}));
    }

    @Test
    public void testSetMax(){
        Basket basket = new Basket();

        //Set max to positive number
        Assertions.assertTrue(Basket.setMaxSize(10));

        //Set max to zero
        Assertions.assertTrue(Basket.setMaxSize(0));

        //Set max to negative number
        Assertions.assertFalse(Basket.setMaxSize(-20));

        Assertions.assertEquals(0, Basket.getMaxSize());
    }

    @Test
    public void testGetCostOfFilling(){
        Basket basket = new Basket();
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");

        //Test get cost of filling
        Assertions.assertEquals(0.12, basket.getCostOfFilling(filling1));

    }
    @Test
    public void testGetCostOfBagel(){
        Basket basket = new Basket();
        Bagel bagelplain = new Bagel("BGLP", 0.39, "Plain");
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

        Bagel bagelWithFilling = new Bagel("BGLP", 0.39, "Plain", fillings);

        //Get cost of plain bagel
        Assertions.assertEquals(0.39, basket.getCostOfBagel(bagelplain));

        //Get cost of bagel with filling on
        Assertions.assertEquals(0.63, basket.getCostOfBagel(bagelWithFilling));
    }
    @Test
    public void testGetTotalCost(){
        Bagel bagelplain = new Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new Bagel("BGLO", 0.49, "Onion");
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

        Bagel bagelWithFilling = new Bagel("BGLP", 0.39, "Plain", fillings);

        Basket basket = new Basket();

        basket.add(bagelplain);
        basket.add(bagelWithFilling);
        basket.add(bagelOnion);

        Assertions.assertEquals( 1.51,basket.getCostOfBasket());
    }
}
