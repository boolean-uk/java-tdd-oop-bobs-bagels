package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static int capacity = 10;
    private List<Item> items = new ArrayList<>();

    public boolean addItem(String sku, double price, String name, String variant, int size) {
        Item item = new Item(sku, price, name, variant, size);
        return addItem(item);
    }

    public boolean addItem(Item item) {
        if (canFitItem(item)) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean canFitItem(Item item) {
        if (items.size() + item.getSize() > capacity) {
            System.out.println("You cannot fit more items in your basket.");
            return false;
        }
        return true;
    }

    public boolean addItem(String sku, double price, String name, String variant) {
        // Shorthand, assuming size=1
        return addItem(sku, price, name, variant, 1);
    }


        public boolean removeItem(String sku) {
        int indexToRemove = 0;
        boolean foundItem = false;
        for (int i=0; i<items.size(); i++) {
            if (sku.equals(items.get(i).getSku())) {
                indexToRemove = i;
                foundItem = true;
                break;
            }
        }
        if (foundItem) {
            items.remove(indexToRemove);
            return true;
        }
        return false;
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
