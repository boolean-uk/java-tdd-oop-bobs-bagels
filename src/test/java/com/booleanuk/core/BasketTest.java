package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addBagel(bagel2);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testRemoveBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel);
        Assertions.assertEquals(1, basket.size());
        basket.removeBagel(bagel);
        Assertions.assertEquals(0, basket.size());
    }

    @Test
    public void testRemoveNonexistentBagel() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        basket.addBagel(bagel1);
        Assertions.assertThrows(NoSuchElementException.class, () -> basket.removeBagel(bagel2));
    }

    @Test
    public void testGetBagelsIsClone() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel1);
        basket.addBagel(bagel2);
        Assertions.assertEquals(2, basket.size());
        ArrayList<Bagel> bagelsCopy = basket.getBagels();
        bagelsCopy.remove(bagel1);
        Assertions.assertEquals(2, basket.size());
        Assertions.assertEquals(1, bagelsCopy.size());
    }

    @Test
    public void testChangeSize() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addBagel(bagel2);
        Assertions.assertEquals(1, basket.size());
        basket.setBasketSize(12);
        basket.addBagel(bagel2);
        Assertions.assertEquals(2, basket.size());
    }
}