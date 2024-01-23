package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Store;
import com.booleanuk.core.StoreInventory;

public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        Store newStore = new Store(inventory);
        Basket basket = new Basket();

        basket.modifyCapacity(30);

        newStore.addToBasket(basket, "BGLP");
        newStore.addToBasket(basket, "BGLP");
        newStore.addToBasket(basket, "BGLP");
        newStore.addToBasket(basket, "COFB");
        newStore.addToBasket(basket, "COFB");

        Receipt receipt = new Receipt(basket, newStore);

        StringBuilder yourReceipt = receipt.generateReceipt();

        System.out.println(yourReceipt);
    }
}
