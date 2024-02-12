package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    @Test
    public void testAdd(){
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        basket.addItem(bagel);
        Assertions.assertTrue(basket.getItems().contains(bagel));
    }

    @Test
    public void testRemove(){
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        basket.addItem(bagel);
        basket.remove(bagel);
        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void testFull(){
        Basket basket = new Basket(2);
        Bagel bagelOnion = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Bagel bagelBacon = new Bagel("BGLO", 0.49, "Bagel", "Bacon");
        basket.addItem(bagelOnion);
        basket.addItem(bagelBacon);
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    public void testTotalCost(){
        Basket basket = new Basket(5);
        Bagel bagelOnion = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Bagel bagelBacon = new Bagel("BGLO", 0.49, "Bagel", "Bacon");
        basket.addItem(bagelOnion);
        basket.addItem(bagelBacon);
        ArrayList<Bagel> items = new ArrayList<>();
        items.add(bagelOnion);
        items.add(bagelBacon);
        double expCost = bagelOnion.getPrice() + bagelBacon.getPrice();
        Assertions.assertEquals(expCost, basket.getTotalCost(), 0.001);
    }

    @Test
    public void testChangeCapacity(){
       Basket basket = new Basket(2);
       Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
       basket.addItem(bagel);
       ArrayList<Bagel> items = new ArrayList<>();
       items.add(bagel);
       basket.changeCapacity(4);
       Assertions.assertFalse(basket.isFull());
    }


}
