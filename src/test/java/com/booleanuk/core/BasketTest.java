package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {

   @Test
   public void createBasketTest() {
       Basket basket = new Basket();

       Assertions.assertTrue(basket.countTotalItems());
   }
}
