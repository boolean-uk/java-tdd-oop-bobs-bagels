package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReceiptTest {
    @Test
    public void checkIfReceiptContainsCorrectWords() {
        StoreInventory inventory = new StoreInventory();
        Store newStore = new Store(inventory);
        Basket basket = new Basket();

        newStore.addToBasket(basket, "BGLO");
        newStore.addToBasket(basket, "BGLO");
        newStore.addToBasket(basket, "BGLP");
        newStore.addToBasket(basket, "BGLP");
        newStore.addToBasket(basket, "FILC");
        basket.modifyCapacity(10);
        newStore.addToBasket(basket, "COFB");

        Receipt receipt = new Receipt(basket, newStore);

        StringBuilder yourReceipt = receipt.generateReceipt();

        Assertions.assertTrue(yourReceipt.indexOf("Thank you") != -1);
        Assertions.assertTrue(yourReceipt.indexOf("Bagel") != -1);
        Assertions.assertTrue(yourReceipt.indexOf("Coffee") != -1);
        Assertions.assertFalse(yourReceipt.indexOf("Waffles") != -1);
    }
}

