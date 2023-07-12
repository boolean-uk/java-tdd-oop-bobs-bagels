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
        if (!isBasketFull()) {
            Optional<Item> optional = Inventory.searchInventory(name, variant);
            optional.ifPresentOrElse(item -> this.shoppingList.put(item, this.shoppingList.getOrDefault(item, 0) + 1),
                    () -> System.out.println("Item not found in inventory"));
        } else {
            System.out.println("Basket is full.");
        }
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

    public void changeCapacity(int capacity){
        if (capacity<= 0) System.out.println("Capacity cannot be less than 1.");
        else if (capacity < shoppingList.size()) {
            System.out.println("Capacity cannot be smaller than no. of items in basket.");
        } else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBasketFull() {
        return shoppingList.size() == capacity;
    }

    public double totalCost(){
        return shoppingList.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getValue() * entry.getKey().getPrice())
                .sum();
    }

    public Map<Item, Integer> getShoppingList() {
        return this.shoppingList;
    }
}
