package com.booleanuk.core;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item;

public class Shop {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        basket.add(new Coffee("COFB"));
        Item item = basket.getItems().get(0);
        System.out.println(item.getName());
        System.out.println(item.getPrice());
        System.out.println(item.getClass());
    }
}
