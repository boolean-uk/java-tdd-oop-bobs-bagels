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

        basket.addPrice("Onion", 0.49);
        basket.addPrice("Plain", 0.39);
        basket.addPrice("Everything", 0.49);


        double totalCost = basket.calculatePrice();


        assertEquals(1.37, totalCost);
    }

    @Test
    public void checkFillingsPrice() {
        Fillings fillings = new Fillings();
        Basket basket = new Basket(fillings);

        fillings.addFillings("FILB", 0.12);
        fillings.addFillings("FILE", 0.12);
        fillings.addFillings("FILC", 0.12);

        Assertions.assertTrue(fillings.fillingChecker());

        Assertions.assertEquals(0.36, fillings.getFillingCost());


    }
}


















