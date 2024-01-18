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
        Bagel bagel1 = new Bagel("BGLO", new String[]{"FILX", "FILC"});
        Bagel bagel2 = new Bagel("BGLO");


        basket.add(bagel1);

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel2));

        //Remove bagel in basket
        Assertions.assertTrue(basket.remove(bagel1));
    }
}