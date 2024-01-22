package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Map;

public class Basket {
    Inventory in = new Inventory();
    Map<String, Item> items = in.items;

    public ArrayList<Item> list = new ArrayList<>();
    public int capacity = 3;
    public String add(Item item) {
        if (items.containsKey(item.getSku())){
            if (list.size() < capacity) {
                if (list.contains(item)) {
                    return "This item already exists in the Basket";
                }
                list.add(item);
                return "Item successfully added";
            }
            return "Your Basket is full";
        } else {
            return "Item is not in the inventory";
        }
    }

    public String remove(Item item) {
        if (list.contains(item)) {
            return "Item successfully removed";
        } else {
            return "This item is not in the basket";
        }
    }


    public String change(int newCap) {
        if (newCap < list.size()) {
            return "New capacity is smaller than the items in the basket";
        }
        capacity = newCap;
        return "New capacity: " +newCap;
    }

    public double totalCost() {
        double cost = 0.0;
        for(Item item : list) {
            cost += item.getPrice();
        }
        return cost;
    }

    public double seeCost(Item item) {
        return item.getPrice();
    }
}
