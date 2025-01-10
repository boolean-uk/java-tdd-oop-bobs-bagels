package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static int capacity = 5;
    private List<Item> items = new ArrayList<>();

    public boolean addItem(String sku, double price, String name, String variant) {
        if (items.size() >= capacity) {
            System.out.println("You cannot fit more items in your basket.");
            return false;
        }
        items.add(new Item());
        return true;
    }

    public boolean removeItem(String sku) {
        items.removeFirst();
        return true;
    }

    public double getTotalCost() {
        return 0;
    }

    public List<Item> getItems() {
        return items;
    }

    public static void setCapacity(int newCapacity) {
        capacity = newCapacity;
    }

    public static int getCapacity() {
        return capacity;
    }
}
