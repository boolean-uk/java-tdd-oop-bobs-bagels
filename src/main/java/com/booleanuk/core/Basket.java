package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private static int defaultCapacity = 4;
    private int capacity;
    private int currentAmount = 0;
    private final ArrayList<Item> items;
    public ArrayList<String> availableDiscounts;
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
    public void fillAvailableDiscounts() {
        availableDiscounts = new ArrayList<String>();
        availableDiscounts.add("6xBGLO,newPrice=2.49");
        availableDiscounts.add("12xBGLP,newPrice=3.99");
        availableDiscounts.add("6xBGLE,newPrice=2.49");
        availableDiscounts.add("1xCOFB,1xBGL,newPrice=1.25");
    }
    public Basket() {
        fillAvailableDiscounts();
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
            case "COF" -> items.add(new Item(itemType));
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
        for(Item item : items)
            if(item.getSku().equals(itemType.getSku()))
                toRemove = item;
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
        return Math.round(totalPrice * 100) / (double)100;
    }
    public void calculateDiscounts() {
        HashMap<IItemType, Integer> itemsCount = new HashMap<IItemType, Integer>();
        for(BagelType bagelType : BagelType.values())
            itemsCount.put(bagelType, 0);
        for(CoffeeType coffeeType : CoffeeType.values())
            itemsCount.put(coffeeType, 0);

    }
}
