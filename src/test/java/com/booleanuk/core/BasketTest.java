package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testBasket(){
        Basket basket = new Basket(10);
        Assertions.assertEquals(10, basket.capacity);
    }

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(10);
        Bagel bagel = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addBagel(bagel);
        Assertions.assertTrue(basket.getListOfBasket().contains(bagel), "The bagel should be in the basket");

    }

    @Test
    public void testRemoveBagel() {
        Basket basket = new Basket(10);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Bagel bagel2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Bagel bagel3 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        basket.addBagel(bagel3);
        basket.removeBagel(bagel1);
        Assertions.assertEquals(2,basket.getListOfBasket().size());

    }

    @Test
    public void testRemoveBagelIfNotExist() {
        Basket basket = new Basket(10);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Bagel bagel2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Bagel bagel3 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        basket.removeBagel(bagel3);
        Assertions.assertEquals(bagel3,"The bagel do not exist in the basket");

    }

    @Test
    public void isFull() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Bagel bagel2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Bagel bagel3 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.PLAIN);
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        basket.addBagel(bagel3);
        Assertions.assertEquals(2,basket.getListOfBasket().size());


    }



}
