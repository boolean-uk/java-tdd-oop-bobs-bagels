package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    public void testAdd(){
       Basket basket = new Basket();
       basket.setMaxSize(1);
       Bagel bagelRight = new Bagel("BGLO");

       //Add Bagel
       Assertions.assertTrue(basket.add(bagelRight));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add(bagelRight));

    }

    @Test
    public void testRemove(){
        Basket basket = new Basket();
        Bagel bagel1 = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLO");
        basket.add(bagel1);

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel2));

        //Remove bagel in basket
        Assertions.assertTrue(basket.remove(bagel1));
    }

    @Test
    public void testAddFillings(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLO");
        Filling filling1 = new Filling("FILB");
        Filling filling2 = new Filling("FILE");
        basket.add(bagel);

        //Add single filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, new Filling[]{filling1}));

        //Add multiple filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, new Filling[]{filling1, filling2}));

        //Add filling to bagel not in basket
        Assertions.assertFalse(basket.addFillings(bagel2, new Filling[]{filling1}));
    }
}