package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Basket {
    private int capacity;
    private Map<Item, Integer> shoppingList;

    public Basket(int capacity) {
        shoppingList = new HashMap<>();
        this.capacity = capacity;
    }


    public void add(String name, String variant) {
        Optional<Item> optional = Inventory.searchInventory(name,variant);
        optional.ifPresentOrElse(item -> this.shoppingList.put(item, this.shoppingList.getOrDefault(item, 0) + 1),
                () -> System.out.println("Item not found in inventory"));
    }

    public void remove(String name, String variant) {
        Optional<Item> optional = Inventory.searchInventory(name,variant);
        optional.ifPresentOrElse(item -> {
            int quantity = this.shoppingList.getOrDefault(item, 0);

            if (quantity > 1) {
                this.shoppingList.put(item, quantity - 1);
            } else if (quantity == 1) {
                this.shoppingList.remove(item);
            } else {
                System.out.println("Item not found in basket");
            }
        }, () -> System.out.println("Item not found in inventory"));
    }



    public Map<Item, Integer> getShoppingList() {
        return this.shoppingList;
    }
}
