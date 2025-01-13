package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    void testAddItemBasketNotFullInStock() {
        // add onion bagle to stock
        Inventory inventory = new Inventory();
        inventory.addStock(SKU.BGLO, 1);

        Basket basket = new Basket(inventory, 3);

        Item item = new Item(SKU.BGLO);

        Assertions.assertTrue(basket.addItem(item));
        Assertions.assertEquals(SKU.BGLO, basket.getItems().get(0).getSku());
    }

    @Test
    void testAddItemNotInStock() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 3);

        Item item = new Item(SKU.BGLO);

        Assertions.assertFalse(basket.addItem(item));
    }

    @Test
    void testAddItemFullBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 0);

        Item item = new Item(SKU.BGLO);

        Assertions.assertFalse(basket.addItem(item));
    }

    @Test
    void testRemoveItemThatExists() {
        // add onion bagle to stock
        Inventory inventory = new Inventory();
        inventory.addStock(SKU.BGLO, 1);

        Basket basket = new Basket(inventory, 5);
        basket.addItem(new Item(SKU.BGLO));

        Assertions.assertTrue(basket.removeItem(SKU.BGLO));
        Assertions.assertTrue(inventory.checkStock(SKU.BGLO)); // check if item is added back to stock
    }

    @Test
    void testGetTotalCost() {
        Inventory inventory = new Inventory();

        inventory.addStock(SKU.BGLO, 2);
        inventory.addStock(SKU.COFB, 1);

        Basket basket = new Basket(inventory, 5);
        basket.addItem(new Item(SKU.BGLO));
        basket.addItem(new Item(SKU.BGLO));
        basket.addItem(new Item(SKU.COFB));

        Assertions.assertEquals(1.97f, basket.getTotalCost());

    }
}
