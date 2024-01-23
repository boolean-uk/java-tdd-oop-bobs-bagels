package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BasketTest {
    @Test
    public void testAddRight(){
        Basket basket = new  Basket();
        Basket.setMaxSize(3);
        Bagel bagelNoFillings = new  Bagel("BGLO", 0.49, "Onion");

        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
       ArrayList< Filling> fillings = new ArrayList<>();
       fillings.add(filling1);

        Bagel bagelWfillings = new  Bagel("BGLO", 0.49, "Onion", fillings);

       //Add Bagel With no filling
       Assertions.assertTrue(basket.add(bagelNoFillings, 1));

       //Add Bagel With filling
        Assertions.assertTrue(basket.add(bagelWfillings, 1));

        //AddCoffee
        Coffee black = new Coffee("COFB", 0.99, "Black");
        Assertions.assertTrue(basket.add(black, 1));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add(bagelNoFillings, 1));

    }

    @Test
    public void testAddWrong(){
         Basket basket = new  Basket();

         Bagel bagelWrongPrice = new  Bagel("BGLO", 0.69, "Onion");
         Bagel bagelWrongVariant = new  Bagel("BGLO", 0.39, "Plain");
         Bagel bagelWrongId = new  Bagel("BGL", 0.39, "Plain");

        //Add Wrong Bagel
        Assertions.assertFalse(basket.add(bagelWrongPrice, 1));
        Assertions.assertFalse(basket.add(bagelWrongVariant, 1));
        Assertions.assertFalse(basket.add(bagelWrongId, 1));
        Assertions.assertFalse(basket.add(bagelWrongPrice, 1));

        Filling filling1 = new Filling("FILB", 0.12, "Bacon");

        //Add filling
        Assertions.assertFalse(basket.add(filling1, 1));
    }

    @Test
    public void testRemove(){
         Basket basket = new  Basket();
         Bagel bagel1 = new  Bagel("BGLO", 0.49, "Onion");
         Bagel bagel2 = new  Bagel("BGLO", 0.49, "Onion");
        basket.add(bagel1, 1);

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel2));

        //Remove bagel in basket
        Assertions.assertTrue(basket.remove(bagel1));
    }

    @Test
    public void testAddFillings(){
         Basket basket = new  Basket();
         Bagel bagel = new  Bagel("BGLO", 0.49, "Onion");
         Bagel bagel2 = new  Bagel("BGLO", 0.49, "Onion");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");
         Filling fillingWrong = new  Filling("FIL", 0.12, "Egg");

        ArrayList< Filling> fillings = new ArrayList< Filling>();
        fillings.add(filling1);
        fillings.add(filling2);

        ArrayList< Filling>  wrongfillings = new ArrayList< Filling>();
        wrongfillings.add(fillingWrong);
        basket.add(bagel, 1);

        //Add multiple filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, fillings));

        //Add incorrect filling
        Assertions.assertFalse(basket.addFillings(bagel, wrongfillings));

        //Add filling to bagel not in basket
        Assertions.assertFalse(basket.addFillings(bagel2, fillings));
    }

    @Test
    public void testSetMax(){
         Basket basket = new  Basket();

        //Set max to positive number
        Assertions.assertTrue( Basket.setMaxSize(10));

        //Set max to zero
        Assertions.assertTrue( Basket.setMaxSize(0));

        //Set max to negative number
        Assertions.assertFalse( Basket.setMaxSize(-20));

        Assertions.assertEquals(0,  Basket.getMaxSize());
    }

    @Test
    public void testGetCostOfCoffee(){
         Basket basket = new  Basket();
         Filling coffee = new  Filling("COFB", 0.99, "Black");

        //Test get cost of Coffee
        Assertions.assertEquals(0.99, basket.getCostOfProduct(coffee));

    }

    @Test
    public void testGetCostOfFilling(){
        Basket basket = new  Basket();
        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");

        //Test get cost of Filling
        Assertions.assertEquals(0.12, basket.getCostOfProduct(filling1));

    }
    @Test
    public void testGetCostOfBagel(){
         Basket basket = new  Basket();
         Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList< Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

         Bagel bagelWithFilling = new  Bagel("BGLP", 0.39, "Plain", fillings);

        //Get cost of plain bagel
        Assertions.assertEquals(0.39, basket.getCostOfProduct(bagelplain));

        //Get cost of bagel with filling on
        Assertions.assertEquals(0.63, basket.getCostOfProduct(bagelWithFilling));
    }

    @Test
    public void testGetTotalCostNoDisCount(){
         Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
         Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

         Bagel bagelWithFilling = new Bagel("BGLP", 0.39, "Plain", fillings);

         Basket basket = new Basket();

        basket.add(bagelplain, 1);
        basket.add(bagelWithFilling, 1);
        basket.add(bagelOnion, 1);

        Assertions.assertEquals( 1.51,basket.getCostOfBasket());
    }

    @Test
    public void testTwelveDiscountForBagels (){
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelWithFilling = new  Bagel("BGLP", 0.39, "Plain");

        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

        bagelWithFilling.addFillings(fillings);

        //exactly 12-discount
        basket.add(bagelplain, 11);
        basket.add(bagelWithFilling, 1);

        Assertions.assertEquals(3.99+0.24, basket.getCostOfBasket());

        basket.add(bagelplain, 1);

        //more than 12-discount
        Assertions.assertEquals(3.99+0.24+0.39, basket.getCostOfBasket());
    }

    @Test
    public void testEighteenDiscountForBagels (){
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelWithFilling = new  Bagel("BGLP", 0.39, "Plain");

        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

        bagelWithFilling.addFillings(fillings);


        basket.add(bagelWithFilling, 1);
        basket.add(bagelplain, 17);

        //exactly 18-discount
        Assertions.assertEquals(6.72, basket.getCostOfBasket());

        basket.add(bagelplain, 1);

        //more than 18-discount
        Assertions.assertEquals(3.99+2.49+0.24+0.39, basket.getCostOfBasket());
    }

    @Test
    public void testDifferentTypesOfBagelsDiscount (){
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
        Bagel bagelWithFilling = new  Bagel("BGLP", 0.39, "Plain");

        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

        bagelWithFilling.addFillings(fillings);

        //6 plain 6 onion, 1 with filling
        basket.add(bagelWithFilling, 1);
        basket.add(bagelplain, 5);

        basket.add(bagelOnion, 6);

        Assertions.assertEquals(5.22, basket.getCostOfBasket());

    }

    @Test
    public void testCoffeeAndBagelDiscount (){
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
        Coffee cofeewhite = new Coffee("COFW", 1.19, "White");
        Coffee coffeeBlack = new Coffee("COFB", 0.99, "Black");

        //2 Bagels and one Coffee
        basket.add(bagelplain, 2);
        basket.add(bagelOnion, 1);
        basket.add(cofeewhite, 1);
        basket.add(coffeeBlack, 1);

        Assertions.assertEquals(0.49+2.50, basket.getCostOfBasket());

    }
}
