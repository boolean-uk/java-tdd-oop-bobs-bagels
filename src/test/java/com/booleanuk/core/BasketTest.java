package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketTest {

    @BeforeEach
    public void clearLists(){
        Basket basket = new Basket(new Inventory());
        basket.clearList();
    }

    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket(new Inventory());
        Assertions.assertTrue(basket.add(new Product("Bagel", 0.39, "BGLP", "Plain")));
        Assertions.assertFalse(basket.add(new Product("Burger", 0.48, "BGRC", "Cheese")));
        Assertions.assertTrue(basket.add(new Product("Coffee", 0.39, "COFB", "Black")));
        Assertions.assertFalse(basket.add(new Product("Coffee", 0.49, "COFC", "Cuppacchino")));
    }

    @Test
    public void applyDiscount6Bagels(){
        Basket basket = new Basket(new Inventory());
        basket.changeCapacity(20);
        for (int i = 0; i < 5; i++) {
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        Assertions.assertEquals(2.49, basket.getTotal());
    }

    @Test
    public void applyDiscount12Bagels(){
        Basket basket = new Basket(new Inventory());
        basket.changeCapacity(20);
        for (int i = 0; i < 11; i++) {
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        Assertions.assertEquals(3.99, basket.getTotal());
    }

    @Test public void applyDiscount12AndAdd4WithNoDiscount(){
        Basket basket = new Basket(new Inventory());
        basket.changeCapacity(20);
        for (int i = 0; i < 15; i++) {
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        Assertions.assertEquals(5.55, basket.getTotal());
    }

    @Test
    public void testTryRemoveBagelFromList(){
        Basket basket = new Basket(new Inventory());
        basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        Assertions.assertEquals(2, basket.getBasket().size());
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertFalse(basket.remove("BGLOSJU"));
        Assertions.assertEquals(1, basket.getBasket().size());
    }
    @Test
    public void testCheckIfBasketIsFull(){
        Basket basket = new Basket(new Inventory());
        basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 1; i < 5; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
        for (int i = 5; i < 9; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
    }
    @Test
    public void testChangeCapacityOfBasket(){
        Basket basket = new Basket(new Inventory());
        basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        basket.changeCapacity(17);
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 1; i < 5; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 5; i < 9; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertFalse(basket.checkIfBasketIsFull());
        for (int i = 10; i < 18; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertTrue(basket.checkIfBasketIsFull());
    }
    @Test
    public void testTryRemoveBagel(){
        Basket basket = new Basket(new Inventory());
        basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        basket.add(new Product("Bagel", 0.39, "BGLO", "Onion"));
        basket.add(new Product("Bagel", 0.39, "BGLS", "Sesame"));
        Assertions.assertFalse(basket.remove("BGLG"));
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertFalse(basket.remove("BGRE"));
    }
    @Test
    public void testTotalCostOfBasket(){
        Basket basket = new Basket(new Inventory());
        basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        basket.add(new Product("Bagel", 0.39, "BGLO", "Onion"));
        basket.add(new Product("Bagel", 0.39, "BGLS", "Sesame"));
        Assertions.assertEquals(1.17, basket.totalCost());
    }
}
