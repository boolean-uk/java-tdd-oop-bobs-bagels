package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private static int defaultCapacity = 4;
    private int capacity;
    private int currentAmount = 0;
    private ArrayList<Item> items;
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
    public void setItems(ArrayList<Item> items) {
        this.items = items;
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

    public boolean addBagel(Bagel bagel) {
        if(isFull())
            return false;
        items.add(bagel);
        ++currentAmount;
        return true;
    }
    public boolean addBagel(BagelType bagelType) {
        if(isFull())
            return false;
        items.add(new Bagel(bagelType));
        ++currentAmount;
        return true;
    }
    public boolean removeBagel(Bagel bagel) {
        if(!items.contains(bagel))
            return false;
        --currentAmount;
        items.remove(bagel);
        return true;
    }
    public boolean removeBagel(BagelType bagelType) {
        Item toRemove = null;
        for(Item item : items) {
            if(item.getSku().equals(bagelType.name()))
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

}
