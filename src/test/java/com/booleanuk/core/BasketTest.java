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
    public void addDecreaseNumberOfItemsInStock() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Assertions.assertEquals(100, shop.getInventory().get(bglo));
        Assertions.assertEquals(100, shop.getInventory().get(bglp));

        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        Assertions.assertEquals(99, shop.getInventory().get(bglo));
        basket.add(bglo);
        basket.add(bglp);
        Assertions.assertEquals(98, shop.getInventory().get(bglo));
        Assertions.assertEquals(99, shop.getInventory().get(bglp));
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
    public void removeIncreaseNumberOfItemsInStock() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        testInventory.put(bglo, 100);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Assertions.assertEquals(100, shop.getInventory().get(bglo));

        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        Assertions.assertEquals(99, shop.getInventory().get(bglo));
        basket.remove(bglo);
        Assertions.assertEquals(100, shop.getInventory().get(bglo));
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
    public void discountPerItem() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        testInventory.put(bglo, 50);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 16);
        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);

        // 1 for 0.49, 6 for 2.29, 12 for 3.99
        Assertions.assertEquals(3.27, basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(0.65, basket.discountPerItem().get(bglo)[1]);

        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);

        Assertions.assertEquals(5.95, basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(1.89, basket.discountPerItem().get(bglo)[1]);
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
        Assertions.assertEquals(0, basket2.checkSize());
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
        Assertions.assertEquals("New capacity must be non negative.", basket.changeCapacity(-2));
        Assertions.assertEquals(3, basket.getBasketCapacity());
        Assertions.assertEquals("New basket capacity is 5.", basket.changeCapacity(5));
        Assertions.assertEquals(5, basket.getBasketCapacity());
        Assertions.assertEquals("New capacity must be larger than number of items currently in basket.", basket.changeCapacity(2));
    }
}
