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
}
