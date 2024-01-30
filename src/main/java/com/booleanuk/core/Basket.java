package com.booleanuk.core;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    public Map<Item, Integer> items = new HashMap<>();
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public int getNoItems() {
        int total = 0;
        for (int i : items.values()) {
            total += i;
        }
        return total;
    }


    public boolean add(Item item, int quantity, Inventory inventory) {
        // Check if the item exists in the inventory and if there is enough stock
        if (inventory != null && inventory.getQuantity(item) >= quantity && capacity > (getNoItems() + quantity)) {
            if (items.containsKey(item)) {
                items.put(item, items.get(item) + quantity);
            } else {
                items.put(item, quantity);
            }
            inventory.add(item, -quantity);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Item item, int quantity) {
        if (existsInBasket(item) && items.get(item) >= quantity) {
            items.put(item, items.get(item) - quantity);
            return true;
        } else {
            return false;
        }
    }

    public void setCap(int capacity) {
        this.capacity = capacity;
    }

    public int getCap() {
        return capacity;
    }

    public boolean existsInBasket(Item item) {
        return items.containsKey(item) && items.get(item) > 0;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += item.getPrice() * quantity;
        }
        return totalPrice;
    }

    public double getPrice(Item item) {
        return item.getPrice();
    }

}
