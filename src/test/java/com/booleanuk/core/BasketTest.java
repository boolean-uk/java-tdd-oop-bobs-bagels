package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void theTestToAdd() {
        Basket basket = new Basket(3);
        String name = "BGLO";
        basket.add(name);
        Assertions.assertTrue(basket.items.contains(name));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Basket basket = new Basket(3);
        String name = "BGLO";
        basket.add(name);

        Assertions.assertTrue(basket.items.contains(name));

        basket.remove(name);
        Assertions.assertFalse(basket.items.contains(name));
    }

    @Test
    public void testSpaceAvailable() {

        Basket basket = new Basket(3);


        basket.add("BGLO");
        basket.add("BGLP");
        Assertions.assertTrue(basket.add("BGLE"));
        Assertions.assertFalse(basket.add("BGLS"));

    }

    @Test
    public void changeSpaceCapacity() {

        Basket basket = new Basket(3);


        basket.add("BGLO");
        basket.add("BGLP");
        Assertions.assertTrue(basket.add("BGLE"));
        Assertions.assertFalse(basket.add("BGLS"));

        basket.avSpaceSetter(5);

        Assertions.assertTrue(basket.add("BGLS"));


    }

    @Test
    public void checkIfRemoveExists() {

        Basket basket = new Basket(3);
        String name = "BGLO";
        basket.add(name);

        Assertions.assertTrue(basket.items.contains(name));
        basket.remove(name);

        Assertions.assertFalse(basket.items.contains(name));
        basket.remove(name);

    }

    @Test
    public void testCalculateTotalCost() {
        Basket basket = new Basket();

        basket.addPrice("BGLO", 0.49);
        basket.addPrice("BGLP", 0.39);
        basket.addPrice("BGLE", 0.49);


        double totalCost = basket.calculatePrice();


        Assertions.assertEquals(1.37, totalCost);
    }

    @Test
    public void testBasketFillingsTotal() {
        Fillings fillings = new Fillings();
        Basket basket = new Basket(fillings);


        fillings.addFillings("FILB", 0.12);
        fillings.addFillings("FILE", 0.12);

        basket.addPrice("BGLO", 0.39);
        basket.addPrice("BGLP", 0.49);

        Assertions.assertEquals(1.12, basket.calculatePrice());
    }


    @Test
    public void testAdditemsThatExist() {
        Fillings fillings = new Fillings();
        Basket basket = new Basket();

        basket.addPrice("BGLO", 0.49);
        Assertions.assertEquals(1, basket.pricedItems.size());

        basket.addPrice("SDFDF", 0.49);
        Assertions.assertEquals(1, basket.pricedItems.size());


    }


}


















