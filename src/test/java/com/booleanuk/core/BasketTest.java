package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {
    @Test
    public void add() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        Assertions.assertEquals("Item BGLO added to basket.", basket.add(bglo));
        Assertions.assertEquals("Item BGLP added to basket.", basket.add(bglp));

        Item bgle = new Item("BGLE","Bagel", "Everything", 0.49);
        Assertions.assertEquals("Chosen item not in stock.", basket.add(bgle));

        testInventory.put(bgle, 100);
        Assertions.assertEquals("Item BGLE added to basket.", basket.add(bgle));
        Assertions.assertEquals("Basket is full.", basket.add(bglo));
    }

    @Test
    public void remove() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        Item bgle = new Item("BGLE","Bagel", "Everything", 0.49);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        basket.add(bglp);
        Assertions.assertEquals("Item BGLE not in basket.", basket.remove(bgle));
        Assertions.assertEquals("Item BGLO removed from basket.", basket.remove(bglo));
        Assertions.assertEquals(1, basket.getBasketContent().size());
    }

    @Test
    public void totalCost() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        basket.add(bglp);
        basket.add(bglo);

        Assertions.assertEquals(1.37, basket.totalCost());

        Basket basket2 = new Basket(shop, 3);
        Assertions.assertEquals(0.0, basket2.totalCost());
    }

    @Test
    public void checkSize() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        basket.add(bglp);
        basket.add(bglo);
        Assertions.assertEquals(3, basket.checkSize());

        Basket basket2 = new Basket(shop, 3);
        Assertions.assertEquals(0, basket.checkSize());
    }

    @Test
    public void changeCapacity() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        basket.add(bglp);
        basket.add(bglo);


    }
}
