package com.booleanuk.core;

import java.util.ArrayList;
public class Basket {
    Item[] Items = {
            new Item("BGLO", 0.49, "Bagel", "Onion"),
            new Item("BGLP", 0.39, "Bagel", "Plain"),
            new Item("BGLE", 0.49, "Bagel", "Everything"),
            new Item("BGLS", 0.49, "Bagel", "Sesame"),
            new Item("COFB", 0.99, "Coffee", "Black"),
            new Item("COFW", 1.19, "Coffee", "White"),
            new Item("COFC", 1.29, "Coffee", "Cappuccino"),
            new Item("COFL", 1.29, "Coffee", "Latte"),
            new Item("FILB", 0.12, "Filling", "Bacon"),
            new Item("FILE", 0.12, "Filling", "Egg"),
            new Item("FILC", 0.12, "Filling", "Cheese"),
            new Item("FILX", 0.12, "Filling", "Cream Cheese"),
            new Item("FILS", 0.12, "Filling", "Smoked Salmon"),
            new Item("FILH", 0.12, "Filling", "Ham")
    };
    public ArrayList<Item> list = new ArrayList<>();
    public int capacity = 3;
    public String add(Item item) {
        if (list.size() < capacity) {
            if (list.contains(item)) {
                return "This item already exists in the Basket";
            }
            list.add(item);
            return "Item successfully added";
        }
        return "Your Basket is full";
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
