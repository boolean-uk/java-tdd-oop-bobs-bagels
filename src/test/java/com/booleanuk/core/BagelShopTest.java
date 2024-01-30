package com.booleanuk.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BagelShopTest {

    public Item bagel;
    public Item jalapenoBagel;
    public Item creamCheese;
    public Item sesameBagel;
    public Basket basket;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        bagel = new Item("plainBagel", 2.5);
        sesameBagel = new Item("sesameBagel", 3.0);
        creamCheese = new Item("creamCheese", 1.95);
        basket = new Basket(10);
        inventory = new Inventory();
        inventory.add(bagel, 5);
        inventory.add(sesameBagel, 4);
        inventory.add(creamCheese, 10);
    }


    @Test
    void Story1AddBagelToBasket() {
        assertFalse(basket.existsInBasket(bagel));
        basket.add(bagel, 2, inventory);
        assertTrue(basket.existsInBasket(bagel));
        assertEquals(2, basket.getNoItems());
        assertEquals(2.5, basket.getPrice(bagel));
        assertEquals(5, basket.getTotalPrice());
    }

    @Test
    void Story2RemoveBagelFromBasket() {
        basket.add(sesameBagel, 2, inventory);
        assertTrue(basket.remove(sesameBagel, 1));
        assertEquals(1, basket.getNoItems());
        assertFalse(basket.remove(bagel, 1));
        assertEquals(1, basket.getNoItems());
        basket.remove(sesameBagel, 2);
        assertEquals(1, basket.getNoItems());


    }

    @Test
    void Story3BasketFullCapacity() {
        basket.add(bagel, 5, inventory);
        assertTrue(basket.existsInBasket(bagel));
        assertFalse(basket.add(bagel, 1, inventory));
        assertEquals(12.5, basket.getTotalPrice());
    }

    @Test
    void Story4ChangeBasketCapacity() {

        assertEquals(10, basket.getCap());
        basket.setCap(2);
        assertEquals(2, basket.getCap());
        assertFalse(basket.add(bagel, 3, inventory));
    }

    @Test
    void Story5RemoveNonExistingItem() {
        basket.remove(bagel, 2);
        assertFalse(basket.existsInBasket(bagel));
    }

    @Test
    void Story6GetTotalPrice() {
        basket.add(bagel, 2, inventory);
        basket.add(sesameBagel, 2, inventory);
        assertEquals(4, basket.getNoItems());
        assertEquals(11, basket.getTotalPrice());
    }

    @Test
    void Story789AddItemGetItemPrice() {
        assertEquals(2.5, basket.getPrice(bagel));
        assertEquals(1.95, basket.getPrice(creamCheese));
        assertEquals(3.0, basket.getPrice(sesameBagel));
        assertNotEquals(3.5, basket.getPrice(sesameBagel));
        basket.add(creamCheese, 1, inventory);
        assertEquals(1, basket.getNoItems());
        assertEquals(1.95, basket.getPrice(creamCheese));
    }

    @Test
    void Story10AddBagelToBasketWhenNotInStock() {
        jalapenoBagel = new Item("jalapenoBagel", 2.5);
        assertFalse(inventory.existsInStock(jalapenoBagel));
        assertFalse(basket.add(jalapenoBagel, 2, inventory));
        assertFalse(basket.add(sesameBagel, 5, inventory));
        assertTrue(basket.add(bagel, 1, inventory));

    }
}