package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestReceipt {
    @Test
    void TestGetRecipet() {
        Inventory inventory = new Inventory();

        inventory.addStock(SKU.BGLO, 2);
        inventory.addStock(SKU.COFB, 1);

        Basket basket = new Basket(inventory, 5);
        basket.addItem(new Item(SKU.BGLO));
        basket.addItem(new Item(SKU.BGLO));
        basket.addItem(new Item(SKU.COFB));

        Receipt receipt = new Receipt(basket.getItems());

        String expected = "";

        Assertions.assertEquals(expected, receipt.getReceipt());

    }
}
