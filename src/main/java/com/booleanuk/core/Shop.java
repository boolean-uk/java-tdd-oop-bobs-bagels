package com.booleanuk.core;

import java.util.HashMap;

public class Shop {

    public static void main(String[] args) {
        Inventory inventory = new BagelShopInventory();
        Basket basket = new Basket(inventory, 10);

        basket.add(new Coffee("COFB"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLP"));

        HashMap <String, Integer> amounts = basket.checkAmountOfItem();
        amounts.forEach((key, value) -> System.out.println(key + " " + value));

    }
}
