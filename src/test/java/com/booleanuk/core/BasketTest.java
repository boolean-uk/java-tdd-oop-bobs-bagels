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
       Bagel bagelWrong = new Bagel("OLLD");

       //Add Bagel
       Assertions.assertTrue(basket.add(bagelRight));

//       //Add bagel with correct fillings
//       Assertions.assertTrue(basket.add("BGLO", new String[]{"FILX", "FILC"} ));
//
//       //Add bagel with incorrect fillings
//       Assertions.assertFalse(basket.add("BGLO", new String[]{"FILX", "FIL"}));
//
//       //Add Filling (You can not only buy a filling)
//       Assertions.assertFalse(basket.add("FILC"));

       //Add With wrong ID
       Assertions.assertFalse(basket.add(bagelWrong));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add(bagelRight));

    }

    @Test
    public void testRemove(){
        Basket basket;
        Bagel bagel1 = new Bagel("BGLO", new String[]{"FILX", "FILC"});
        Bagel bagel2 = new Bagel("BGLO");
        Bagel bagel3 = Inventory.getBagels().get("BGLO");

       // Assertions.assertFalse(basket.add();

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel1));

        //Remove bagel in basket
    }
}