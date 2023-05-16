package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    public void testAdd(){
        Basket basket = new Basket(2);

        Assertions.assertEquals(0,basket.getProducts().size());

        Assertions.assertFalse(basket.add("wrongSKU"));
        Assertions.assertEquals(0,basket.getProducts().size());

        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertEquals(1,basket.getProducts().size());

        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertEquals(2,basket.getProducts().size());

        Assertions.assertFalse(basket.add("BGLE"));
        Assertions.assertEquals(2,basket.getProducts().size());
    }

    @Test
    public void testRemoveFromBasket(){
        Basket basket = new Basket(2);
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.remove("BGLP"));
        Assertions.assertFalse(basket.remove("BGLP"));
    }

    @Test
    public void testSetCapacityExpands(){
        Basket basket = new Basket(2);
        basket.setCapacity(3);
        Assertions.assertEquals(3, basket.getCapacity());
        basket.setCapacity(1);
        Assertions.assertEquals(3, basket.getCapacity());
    }

    @Test
    public void testTotalCostOfBasket(){
        //sums up bagels and fillings cost
        Basket basket = new Basket(2);
        Assertions.assertTrue(basket.add("BGLO"));
        Product bagel = basket.getProducts().get(0);
        bagel.addFilling("FILE");
        bagel.addFilling("FILB");
        Assertions.assertEquals(0.73, basket.getTotalCost());
        Assertions.assertTrue(basket.add("BGLS"));
        Assertions.assertEquals(1.22, basket.getTotalCost());
    }

    @Test
    public void testTotalCostOfBasketSpecialOffer(){
        //sums up bagels and fillings cost
        Basket basket = new Basket(100);
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertEquals(2.34, basket.getTotalCost());

        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertEquals(2.73, basket.getTotalCost());

        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertEquals(3.99, basket.getTotalCost());

        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));

        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));

        Product bagel = basket.getProducts().get(0);
        bagel.addFilling("FILH");

        Assertions.assertEquals(7.0, basket.getTotalCost());
    }

    @Test
    public void testPrintReceipt(){
        Basket basket = new Basket(100);
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLS"));
        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFW"));
        Product bagel = basket.getProducts().get(0);
        bagel.addFilling("FILH");
        bagel.addFilling("FILS");
        bagel = basket.getProducts().get(3);
        bagel.addFilling("FILS");
        bagel.addFilling("FILC");
        Assertions.assertTrue(basket.printReceipt());
    }

    @Test
    public void testExtension3Savings(){
        Basket basket = new Basket(30);
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
//        Assertions.assertTrue(basket.add("BGLP"));
//        Assertions.assertTrue(basket.add("BGLP"));


        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLP"));
        Assertions.assertTrue(basket.add("BGLO"));

        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));

        Product bagel = basket.getProducts().get(3);
        bagel.addFilling("FILH");
        bagel.addFilling("FILS");
        bagel = basket.getProducts().get(7);
        bagel.addFilling("FILS");

        Assertions.assertTrue(basket.printReceipt());
    }
}



