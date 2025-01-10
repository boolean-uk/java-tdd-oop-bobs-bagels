package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static int capacity = 5;
    private List<Item> items = new ArrayList<>();

    public boolean addItem(String sku, double price, String name, String variant, int size) {
        if (items.size() >= capacity) {
            System.out.println("You cannot fit more items in your basket.");
            return false;
        }
        items.add(new Item(sku, price, name, variant, size));
        return true;
    }

    public boolean addItem(String sku, double price, String name, String variant) {
        // Shorthand, assuming size=1
        return addItem(sku, price, name, variant, 1);
    }


        public boolean removeItem(String sku) {
        items.removeFirst();
        return true;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
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
