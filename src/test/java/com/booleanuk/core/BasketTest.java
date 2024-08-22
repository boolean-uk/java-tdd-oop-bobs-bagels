package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class BasketTest {

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addProduct(bagel2);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testRemoveBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel);
        Assertions.assertEquals(1, basket.size());
        basket.removeProduct(bagel);
        Assertions.assertEquals(0, basket.size());
    }

    @Test
    public void testRemoveNonexistentBagel() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        basket.addProduct(bagel1);
        Assertions.assertThrows(NoSuchElementException.class, () -> basket.removeProduct(bagel2));
    }

    @Test
    public void testGetBagelsIsClone() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
        ArrayList<Product> bagelsCopy = basket.getProducts();
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
        basket.addProduct(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addProduct(bagel2);
        Assertions.assertEquals(1, basket.size());
        basket.setBasketSize(12);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
    }

    @Test
    public void testChangeSizeToSmallerThanNumberOfBagels() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
        basket.setBasketSize(1);
        Assertions.assertEquals(0, basket.size());
    }

    @Test
    public void testCalculateCost() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB"));
        basket.addProduct(bagel1);
        Assertions.assertEquals(0.61f, basket.calculateCost(), 0.001);
        basket.addProduct(bagel2);
        Assertions.assertEquals(1.12f, basket.calculateCost(), 0.001);
    }

    @Test
    public void testCalculateCostOnEmptyBasket() {
        Basket basket = new Basket(2);
        Assertions.assertEquals(0.0f, basket.calculateCost(), 0.001);
    }

    @Test
    public void testFindDiscountOn12Bagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 12; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(1.89f, b.findDiscount(), 0.001);
    }
}