package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertTrue(basket.add(new Item("Bagel", "Plain")));
        Assertions.assertEquals(1, basket.getItems().size());
        Assertions.assertEquals(0.39, basket.getItems().get(0).getPrice());
    }

    @Test
    public void testAddItemFailReachedMaxCapacity() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 3);

        basket.add(new Item("Bagel", "Sesame"));
        basket.add(new Item("Coffee", "Black"));
        basket.add(new Item("Filling", "Egg"));
        Assertions.assertFalse(basket.add(new Item("Bagel", "Plain")));
    }

    @Test
    public void testAddItemFailNotExistInInventory(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertFalse(basket.add(new Item("Sandwich", "Plain")));
        Assertions.assertFalse(basket.add(new Item("Bagel", "Poppy-seed")));
    }

    @Test
    public void testRemoveItemSuccess() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Item item1 = new Item("Bagel", "Plain");
        Item item2 = new Item("Coffee", "Black");
        Item item3 = new Item("Filling", "Egg");
        basket.add(item1);
        basket.add(item2);
        basket.add(item3);
        Assertions.assertTrue(basket.remove(item1));
        Assertions.assertEquals(2, basket.getItems().size());
    }

    @Test
    public void testChangeCapacitySuccess() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        basket.changeCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void testChangeCapacityFail(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertTrue(basket.changeCapacity(5));
        basket.changeCapacity(0);
        Assertions.assertNotEquals(0, basket.getCapacity());
        basket.changeCapacity(-1);
        Assertions.assertNotEquals(-1, basket.getCapacity());
    }

    @Test
    public void testGetTotalCost() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        basket.add(new Item("Bagel", "Sesame"));
        basket.add(new Item("Coffee", "Black"));
        basket.add(new Item("Filling", "Egg"));
        Assertions.assertEquals(1.60, basket.getTotal());
    }

    @Test
    public void testGetItemPrice() {
        Inventory inventory = new Inventory();
        Item item = new Item("BGLS", 0.49,"Bagel", "Sesame");

        Assertions.assertEquals(0.49, inventory.getPrice(item));
    }
}
