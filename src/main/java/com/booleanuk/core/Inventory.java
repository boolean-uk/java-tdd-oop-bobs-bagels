package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Map<Item, Integer> stock = new HashMap<>();

    public void add(Item item, int quantity) {
        int currentStock = stock.getOrDefault(item, 0);
        stock.put(item, currentStock + quantity);
    }
    public boolean existsInStock(Item item) {
        return stock.containsKey(item) && stock.get(item) > 0;
    }
    public int getQuantity(Item item) {
        return stock.getOrDefault(item, 0);
    }
}