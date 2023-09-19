package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void theTestToAdd() {
        Basket basket = new Basket(3);
        String name = "le onion";
        basket.add(name);
        Assertions.assertTrue(basket.contains(name));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Basket basket = new Basket(3);
        String name = "Le onion";
        basket.add(name);

        Assertions.assertTrue(basket.contains(name));

        basket.remove(name);
        Assertions.assertFalse(basket.contains(name));
    }

    @Test
    public void testSpaceAvailable() {

        Basket basket = new Basket(3);


        basket.add("Le onion");
        basket.add("Cream");
        Assertions.assertTrue(basket.add("Egg"));
        Assertions.assertFalse(basket.add("Vanilla"));

    }

    @Test
    public void changeSpaceCapacity() {

        Basket basket = new Basket(3);


        basket.add("Le onion");
        basket.add("Cream");
        Assertions.assertTrue(basket.add("Egg"));
        Assertions.assertFalse(basket.add("Vanilla"));

        basket.avSpaceSetter(5);

        Assertions.assertTrue(basket.add("Vanilla"));


    }

    @Test
    public void checkIfRemoveExists() {

        Basket basket = new Basket(3);
        String name = "Le onion";
        basket.add(name);

        Assertions.assertTrue(basket.contains(name));
        basket.remove(name);

        Assertions.assertFalse(basket.contains(name));
        basket.remove(name);

    }

    @Test
    public void testCalculateTotalCost() {
        Basket basket = new Basket();

        basket.addPrice("Onion", 0.49d);
        basket.addPrice("Plain", 0.39d);
        basket.addPrice("Everything", 0.49d);


        double totalCost = basket.calculatePrice();


        assertEquals(8.25, totalCost);
    }




}


















