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

        Receipt receipt = new Receipt(basket, newStore);

        StringBuilder yourReceipt = receipt.generateReceipt();

        Assertions.assertTrue(yourReceipt.indexOf("Thank you") != -1);
    }
}

