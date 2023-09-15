package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddToBasketSuccessful() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");

        assertTrue(basket.addToBasket(bagelItem,1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
    }
    @Test
    public void testAddToBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLG", new BigDecimal("0.49"), "Bagel", "Garlic");

        assertFalse(basket.addToBasket(bagelItem,1));
        assertEquals(0, basket.getItemsMap().size());
    }

    // test add to basket -> product already exists -> increase quantity


    @Test
    public void testRemoveFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");
        Item bagelItem2 = new Bagel("BGLP",	new BigDecimal("0.39"),	"Bagel",	"Plain");

        assertTrue(basket.addToBasket(bagelItem,2));
        assertEquals(1, basket.getItemsMap().size());
        assertFalse(basket.removeFromBasket(bagelItem2,1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.removeFromBasket(bagelItem,1));
        assertEquals(1, basket.getItemsMap().size());
        assertEquals(1, basket.getItemsMap().get(bagelItem));
        assertTrue(basket.removeFromBasket(bagelItem,1));
        assertEquals(0, basket.getItemsMap().size());

    }


    @Test
    public void testCheckingWhetherBasketIsFull() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");
        assertTrue(basket.addToBasket(bagelItem,1));
        assertFalse(basket.isFull());
        Item bagelItem2 = new Bagel("BGLP",	new BigDecimal("0.39"),	"Bagel",	"Plain");
        assertTrue(basket.addToBasket(bagelItem2,1));
        assertTrue(basket.isFull());
    }

    @Test
    public void testSettingCapacity() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        assertEquals(2, basket.getCapacity());
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");

        assertTrue(basket.addToBasket(bagelItem,2));
        assertTrue(basket.setCapacity(5));
        assertEquals(5, basket.getCapacity());
        Item bagelItem2 = new Bagel("BGLP",	new BigDecimal("0.39"),	"Bagel",	"Plain");
        assertTrue(basket.addToBasket(bagelItem2,2));
        assertFalse(basket.setCapacity(3));
        assertEquals(5, basket.getCapacity());

    }

    @Test
    public void testGetTotalCost() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");
        Item bagelItem2 = new Bagel("BGLP",	new BigDecimal("0.39"),	"Bagel",	"Plain");
        assertEquals(BigDecimal.ZERO, basket.getTotalCost());
        assertTrue(basket.addToBasket(bagelItem,2));
        assertTrue(basket.addToBasket(bagelItem2,2));
        assertEquals(new BigDecimal("1.76"), basket.getTotalCost());
    }

    @Test
    public void testGetItemCost(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", "Onion");
        Item bagelItem2 = new Bagel("BGLP",	new BigDecimal("0.39"),	"Bagel",	"Plain");
        assertTrue(basket.addToBasket(bagelItem,2));
        assertTrue(basket.addToBasket(bagelItem2,2));
        assertEquals(new BigDecimal("1.76"), basket.getItemCost(new Bagel("BGLO")));
        assertEquals(new BigDecimal("1.76"), basket.getItemCost(new Bagel("BGLP")));

        assertEquals(new BigDecimal("1.76"), basket.getTotalCost());
    }
}
