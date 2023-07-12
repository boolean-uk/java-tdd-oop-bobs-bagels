package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private static int defaultCapacity = 4;
    private int capacity;
    private int currentAmount = 0;
    private final ArrayList<Item> items;
    public int getCapacity() {
        return capacity;
    }
    public boolean setCapacity(int capacity) {
        if(capacity < currentAmount)
            return false;
        this.capacity = capacity;
        return true;
    }
    public int getCurrentAmount() {
        return currentAmount;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public static int getDefaultCapacity() {
        return defaultCapacity;
    }
    public static void setDefaultCapacity(int defaultCapacity) {
        Basket.defaultCapacity = defaultCapacity;
    }
    public Basket() {
        items = new ArrayList<Item>();
        capacity = defaultCapacity;
    }

    public boolean addItem(Item item) {
        if(isFull())
            return false;
        items.add(item);
        ++currentAmount;
        return true;
    }
    public boolean addItem(IItemType itemType) {
        if(isFull())
            return false;
        switch (itemType.getSku().substring(0, 3)) {
            case "BGL" -> items.add(new Bagel((BagelType) itemType));
            case "COF" -> items.add(new Item(itemType.getSku(), itemType.getPrice(), itemType.getVariant()));
        }
        ++currentAmount;
        return true;
    }
    public boolean removeItem(Item item) {
        if(!items.contains(item))
            return false;
        --currentAmount;
        items.remove(item);
        return true;
    }
    public boolean removeItem(IItemType itemType) {
        Item toRemove = null;
        for(Item item : items) {
            if(item.getSku().equals(itemType.getSku()))
                toRemove = item;
        }
        if(toRemove != null) {
            items.remove(toRemove);
            return true;
        }
        return false;
    }
    public boolean isFull() {
        return currentAmount == capacity;
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items)
            totalPrice += item.getPrice();
        return totalPrice;

    }
}
