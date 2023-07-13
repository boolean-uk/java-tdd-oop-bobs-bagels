package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BasketTest {
    @Test
    public void testAddItem() {
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        basket.addProduct(bagel);
        assertTrue(basket.isFull());
    }

    @Test
    public void testRemoveItem() {
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        basket.addProduct(bagel);
        basket.removeProduct(bagel);
        assertFalse(basket.isFull());
    }

    @Test
    public void testIsFull() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        assertTrue(basket.isFull());
    }

    @Test
    public void testGetTotalCost() {
        Basket basket = new Basket(3);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        double expectedCost = bagel1.getPrice() + bagel2.getPrice();
        assertEquals(expectedCost, basket.getTotalCost(), 0.001);
    }
}

