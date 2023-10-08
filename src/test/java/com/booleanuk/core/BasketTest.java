package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void addToBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        Item itemBGLO = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
    }

    @Test
    public void addToBasketFails() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 1);
        Item itemBGLO = new Bagel("BGLE", 0.49, "Bagel", "Everything");
        Item itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
        assertFalse(basket.addToBasket(itemBGLP));
        assertEquals(1, basket.getItemBasket().size());

    }

    @Test
    public void removeFromBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 1);
        Item itemBGLO = new Bagel("BGLS", 0.49, "Bagel", "Sesame");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.removeFromBasket(itemBGLO));
        assertEquals(0, basket.getItemBasket().size());
    }

    @Test
    public void removeFromBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        Item itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Item itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertFalse(basket.removeFromBasket(itemBGLP));
        assertEquals(1, basket.getItemBasket().size());
    }

    @Test
    public void changeBasketSize() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory,1);

        assertTrue(basket.addToBasketSize(1));
        assertEquals(2, basket.getBasketSize());

        assertFalse(basket.addToBasketSize(-2));
        assertEquals(2, basket.getBasketSize());

    }

    @Test
    public void getTotalCost() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        Item itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Item itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertTrue(basket.addToBasket(itemBGLP));
        assertEquals(2, basket.getItemBasket().size());

        double expectedCost = itemBGLO.getPrice() +itemBGLP.getPrice();
        assertEquals(expectedCost, basket.getTotalCost());

    }

    @Test
    public void addBagelAndFilling() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        Item itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Item itemFILH = new Fillings("FILH", 0.12, "Filling", "Ham");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
        assertTrue(basket.addToBasket(itemFILH));
        assertEquals(2, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemFILH));
    }

    @Test
    public void setSKU() {
        Item inventoryItem = new Coffee("COFB", 0.99, "Coffee", "Black") {
        };

        Assertions.assertEquals("COFB",inventoryItem.getSKU());
        inventoryItem.setSKU("COFW");
        Assertions.assertEquals("COFW", inventoryItem.getSKU());
    }

    @Test
    public void itemPrice() {
        Item item = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals(0.49, item.getPrice());
        item.setPrice(1.19);
        Assertions.assertEquals(1.19, item.getPrice());
    }

    @Test
    public void itemName() {
        Item item = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals("Bagel", item.getName());
        item.setName("Coffee");
        Assertions.assertEquals("Coffee", item.getName());
    }

    @Test
    public void itemVariant() {
        Item item = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals("Onion", item.getVariant());
        item.setVariant("Plain");
        Assertions.assertEquals("Plain", item.getVariant());
    }

    @Test
    public void itemBagelPrice() {
        Item bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals(0.49, bagel.getPrice());
    }
    @Test
    public void itemFillingPrice() {
        Item filling = new Fillings("FILH", 0.12, "Filling", "Ham");

        Assertions.assertEquals(0.12, filling.getPrice());
    }
}