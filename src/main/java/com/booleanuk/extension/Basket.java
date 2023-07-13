package com.booleanuk.extension;

import java.util.*;

public class Basket {
    private static int defaultCapacity = 4;
    private int capacity;
    private int currentAmount = 0;
    private final ArrayList<Item> items;
    public ArrayList<String> availableDiscounts;
    public static HashMap<String, IItemType> itemTypeBySku;
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
        availableDiscounts.add("6*BGLO,newPrice=2.49");
        availableDiscounts.add("12*BGLP,newPrice=3.99");
        availableDiscounts.add("6*BGLE,newPrice=2.49");
        availableDiscounts.add("1*COFB,1*BGLP,newPrice=1.25");
        availableDiscounts.add("1*COFB,1*BGLO,newPrice=1.25");
        availableDiscounts.add("1*COFB,1*BGLE,newPrice=1.25");
        availableDiscounts.add("1*COFB,1*BGLS,newPrice=1.25");
    }
    public void fillItemsBySku() {
        itemTypeBySku = new HashMap<String, IItemType>();
        for (BagelType bagelType : BagelType.values())
            itemTypeBySku.put(bagelType.getSku(), bagelType);
        for (CoffeeType coffeeType : CoffeeType.values())
            itemTypeBySku.put(coffeeType.getSku(), coffeeType);
        for (FillingType fillingType : FillingType.values())
            itemTypeBySku.put(fillingType.getSku(), fillingType);
    }
    public Basket() {
        fillAvailableDiscounts();
        fillItemsBySku();
        items = new ArrayList<Item>();
        capacity = defaultCapacity;
    }
    public void clear() {
        currentAmount = 0;
        items.clear();
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
        HashMap<String, Integer> activeDiscounts = calculateDiscounts();
        for (String discountString : activeDiscounts.keySet()) {
            double initialPrice = 0;
            List<String> discountedItems = new LinkedList<String>(Arrays.asList(discountString.split(",")));
            String priceString = discountedItems.remove(discountedItems.size() - 1);
            double newPrice = Double.parseDouble(priceString.substring(priceString.indexOf("=") + 1));
            for (String itemString : discountedItems) {
                String itemSku = itemString.substring(itemString.indexOf("*") + 1);
                int itemCount = Integer.parseInt(itemString.substring(0, itemString.indexOf("*")));
                initialPrice += itemTypeBySku.get(itemSku).getPrice() * (double)itemCount;
            }
            totalPrice -= (initialPrice - newPrice) * activeDiscounts.get(discountString);
        }
        return Math.round(totalPrice * 100) / (double)100;
    }
    public HashMap<String, Integer> calculateDiscounts() {
        HashMap<String, Integer> itemsCount = new HashMap<String, Integer>();
        for (BagelType bagelType : BagelType.values())
            itemsCount.put(bagelType.getSku(), 0);
        for (CoffeeType coffeeType : CoffeeType.values())
            itemsCount.put(coffeeType.getSku(), 0);
        for (Item item : items)
            itemsCount.put(item.getItemType().getSku(), itemsCount.get(item.getItemType().getSku()) + 1);

        HashMap<String, Integer> activeDiscounts = new HashMap<String, Integer>();
        for (String discountString : availableDiscounts) {
            List<String> discountedItems = new LinkedList<String>(Arrays.asList(discountString.split(",")));
            discountedItems.remove(discountedItems.size() - 1);
            int numberOfApplies = -1;
            for (String itemString : discountedItems) {
                String itemSku = itemString.substring(itemString.indexOf("*") + 1);
                int itemCount = Integer.parseInt(itemString.substring(0, itemString.indexOf("*")));
                numberOfApplies = numberOfApplies == - 1 ? itemsCount.get(itemSku) / itemCount :
                        Math.min(numberOfApplies, itemsCount.get(itemSku) / itemCount);
            }
            if (numberOfApplies > 0) {
                for (String itemString : discountedItems) {
                    String itemSku = itemString.substring(itemString.indexOf("*") + 1);
                    int itemCount = Integer.parseInt(itemString.substring(0, itemString.indexOf("*")));
                    itemsCount.put(itemSku, itemsCount.get(itemSku) - itemCount * numberOfApplies);
                }
            }
            activeDiscounts.put(discountString, numberOfApplies);
        }
        return activeDiscounts;
    }
}

