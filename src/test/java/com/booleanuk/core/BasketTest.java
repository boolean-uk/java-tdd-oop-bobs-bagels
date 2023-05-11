package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add(new Item("Bagel", "Plain")));
        Assertions.assertEquals(1, basket.items.size());
        Assertions.assertEquals(0.39, basket.items.get(0).price);
    }

    @Test
    public void testAddItemFailReachedMaxCapacity() {
        Basket basket = new Basket();
        basket.add(new Item("Bagel", "Sesame"));
        basket.add(new Item("Coffee", "Black"));
        basket.add(new Item("Filling", "Egg"));
        Assertions.assertFalse(basket.add(new Item("Bagel", "Plain")));
    }

    @Test
    public void testAddItemFailNotExistInInventory(){
        Basket basket = new Basket();
        Assertions.assertFalse(basket.add(new Item("Sandwich", "Plain")));
        Assertions.assertFalse(basket.add(new Item("Bagel", "Poppy-seed")));
    }

    @Test
    public void testRemoveItemSuccess() {
        Basket basket = new Basket();
        Item item1 = new Item("Bagel", "Plain");
        Item item2 = new Item("Coffee", "Black");
        Item item3 = new Item("Filling", "Egg");
        basket.items.add(item1);
        basket.items.add(item2);
        basket.items.add(item3);
        Assertions.assertTrue(basket.remove(item1));
        Assertions.assertEquals(2, basket.items.size());
    }

    @Test
    public void testChangeCapacitySucces() {
        Basket basket = new Basket();
        basket.changeCapacity(5);
        Assertions.assertEquals(5, basket.capacity);
    }

    @Test
    public void testChangeCapacityFail(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.changeCapacity(5));
        basket.changeCapacity(0);
        Assertions.assertNotEquals(0, basket.capacity);
        basket.changeCapacity(-1);
        Assertions.assertNotEquals(-1, basket.capacity);

    }

}
