package com.booleanuk.core;

import java.util.HashMap;

public class Shop {

    public static void main(String[] args) {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory, 30);
        Receipt receipt = new Receipt(basket);

        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLO"));
        basket.add(new Coffee("COFB"));

        receipt.printReceipt();
    }
}
