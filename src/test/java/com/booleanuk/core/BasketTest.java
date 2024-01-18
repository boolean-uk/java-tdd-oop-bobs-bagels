package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    public void testAdd(){
       Basket basket = new Basket();
       basket.setMaxSize(2);

       //Add Coffee or Bagel
       Assertions.assertTrue(basket.add("BGLO"));
       Assertions.assertTrue(basket.add("COFB"));

       //Add Filling (You can not only buy a filling)
       Assertions.assertFalse(basket.add("FILC"));

       //Add With wrong ID
       Assertions.assertFalse(basket.add("BSGO"));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add("BGLO"));

    }
}