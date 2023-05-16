package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        Assertions.assertTrue(basket.add(new Bagel("BGLP")));
        Assertions.assertEquals(1, basket.getItems().size());
        Assertions.assertEquals(0.39, basket.getItems().get(0).getPrice());
    }

    @Test
    public void testAddItemFailReachedMaxCapacity() {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory, 3);

        basket.add(new Bagel("BGLS"));
        basket.add(new Coffee("COFB"));
        basket.add(new Filling("FILE"));
        Assertions.assertFalse(basket.add(new Bagel("BGLP")));
    }

    @Test
    public void testAddItemFailNotExistInInventory(){
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        Assertions.assertFalse(basket.add(new Bagel("SNDP")));
        Assertions.assertFalse(basket.add(new Filling("BGLW")));
    }

    @Test
    public void testRemoveItemSuccess() {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        Item item1 = new Bagel("BGLP");
        Item item2 = new Coffee("COFB");
        Item item3 = new Filling("FILE");
        basket.add(item1);
        basket.add(item2);
        basket.add(item3);
        Assertions.assertTrue(basket.remove(item1));
        Assertions.assertEquals(2, basket.getItems().size());
    }

    @Test
    public void testChangeCapacitySuccess() {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        basket.changeCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void testChangeCapacityFail(){
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        Assertions.assertTrue(basket.changeCapacity(5));
        basket.changeCapacity(0);
        Assertions.assertNotEquals(0, basket.getCapacity());
        basket.changeCapacity(-1);
        Assertions.assertNotEquals(-1, basket.getCapacity());
    }

    @Test
    public void testGetTotalCost() {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory);

        basket.add(new Bagel("BGLS"));
        basket.add(new Coffee("COFB"));
        basket.add(new Filling("FILE"));
        Assertions.assertEquals(1.60, basket.getTotal());
    }
}
