package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertTrue(basket.add(new Item("BGLP")));
        Assertions.assertEquals(1, basket.getItems().size());
        Assertions.assertEquals(0.39, basket.getItems().get(0).getPrice());
    }

    @Test
    public void testAddItemFailReachedMaxCapacity() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 3);

        basket.add(new Item("BGLS"));
        basket.add(new Item("COFB"));
        basket.add(new Item("FILE"));
        Assertions.assertFalse(basket.add(new Item("BGLP")));
    }

    @Test
    public void testAddItemFailNotExistInInventory(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertFalse(basket.add(new Item("SNDP")));
        Assertions.assertFalse(basket.add(new Item("BGLW")));
    }

    @Test
    public void testRemoveItemSuccess() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Item item1 = new Item("BGLP");
        Item item2 = new Item("COFB");
        Item item3 = new Item("FILE");
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

        basket.add(new Item("BGLS"));
        basket.add(new Item("COFB"));
        basket.add(new Item("FILE"));
        Assertions.assertEquals(1.60, basket.getTotal());
    }
}
