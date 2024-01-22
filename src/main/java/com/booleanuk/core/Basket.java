package com.booleanuk.core;

import java.util.*;

public class Basket {

    private ArrayList<Item> items;
    private HashMap<String, Integer> itemCounter;
    private double totalCost;
    private Customer customer;

    public Basket(Customer customer) {
        this.items = new ArrayList<>();
        this.totalCost = 0;
        this.customer = customer;
        this.itemCounter = new HashMap<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public Customer getCustomer() {
        return customer;
    }

    public double calculateTotalCost() {
        this.totalCost = 0;
        if(!this.items.isEmpty()) {
            for(Item item : items) {
                this.totalCost += item.getCost();
            }
        }
        System.out.println("Your total is: " + this.totalCost);
        return this.totalCost;
    }

    public String addItem(Item newItem) {
        this.items.add(newItem);
        return "A new item has been added\n" + newItem;
    }

    public boolean capacityChanged() {
        // if basket is empty, do nothing, return true
        if(this.items.isEmpty()) {
            return true;
        }
        // if basket has more elements than capacity, remove overflowing elements, return true
        if(this.items.size() > customer.getStore().getCapacity()) {
            int itemsToRemove = this.items.size() - customer.getStore().getCapacity();
            for(int i = 0; i < itemsToRemove; i++) {
                this.items.remove(this.items.size()-1);
            }
            return true;
        }
        // if basket has less or same number of elements than capacity, do nothing, return true
        if(this.items.size() <= customer.getStore().getCapacity()) {
            return true;
        }
        // if something else, return false
        return false;
    }

public ArrayList<Item> applyDiscounts() {
        ArrayList<Item> tempArray = items;
        tempArray.sort(Comparator.comparing(Item::getSKU));
        double savedMoney = 0;

        // make an HashMap that counts occurrences of items
        for(Item item : tempArray) {
            if(itemCounter.containsKey(item.getSKU())) {
                itemCounter.put(item.getSKU(), itemCounter.get(item.getSKU())+1);
            } else {
                itemCounter.put(item.getSKU(), 1);
            }
        }
        //
        while (itemCounter.values().stream().anyMatch(i -> i >= 12)) {
            for (Map.Entry<String, Integer> entry : itemCounter.entrySet()) {
                if (itemCounter.get(entry.getKey()) >= 12) {
                    itemCounter.put(entry.getKey(), itemCounter.get(entry.getKey()) - 12);
                    int indexCounter = 0;
                    for(int i = 0; i < tempArray.size(); i++) {
                        if(tempArray.get(i).getSKU().equals(entry.getKey())) {
                            indexCounter = i;
                        }
                        break;
                    }
                    tempArray.get(indexCounter).setCost(3.99);
                    tempArray.get(indexCounter).setDiscounted(true);
                    for(int i = indexCounter + 1; i <= indexCounter + 11; i++) {
                        tempArray.get(i).setCost(0);
                        tempArray.get(i).setDiscounted(true);
                    }
                }
            }
        }
        while (itemCounter.values().stream().anyMatch(i -> i >= 6)) {
            for (Map.Entry<String, Integer> entry : itemCounter.entrySet()) {
                if (itemCounter.get(entry.getKey()) >= 6) {
                    itemCounter.put(entry.getKey(), itemCounter.get(entry.getKey()) - 6);
                    int indexCounter = 0;
                    for(int i = 0; i < tempArray.size(); i++) {
                        if(tempArray.get(i).getSKU().equals(entry.getKey())) {
                            indexCounter = i;
                        }
                        break;
                    }
                    tempArray.get(indexCounter).setCost(2.49);
                    tempArray.get(indexCounter).setDiscounted(true);
                    for(int i = indexCounter + 1; i <= indexCounter+5; i++) {
                        tempArray.get(i).setCost(0);
                        tempArray.get(i).setDiscounted(true);
                    }
                }
            }
        }

        // finds the remaining
        int remainingBagel = 0;
        int remainingCoffee = 0;
        for (Item item : tempArray) {
            String sku = item.getSKU();
            int quantity = itemCounter.get(sku);
            if (sku.startsWith("BGL") && !item.isDiscounted()) {
                remainingBagel += quantity;
            } else if (sku.startsWith("COF") && !item.isDiscounted()) {
                remainingCoffee += quantity;
            }
        }

        while(Math.min(remainingCoffee,remainingBagel) >= 0) {

            int bagelToDiscount = findMostExpensiveItemWithPrefix(tempArray, "BGL");
            int coffeeToDiscount = findMostExpensiveItemWithPrefix(tempArray, "COF");
            if (bagelToDiscount != -1) {
                tempArray.get(bagelToDiscount).setCost(0.35);
                remainingBagel--;
            }
            if (coffeeToDiscount != -1) {
                tempArray.get(coffeeToDiscount).setCost(0.90);
                remainingCoffee--;
            }
        }
        return tempArray;
}

    private int findMostExpensiveItemWithPrefix(ArrayList<Item> items, String prefix) {
        int indexItem = -1;
        double maxCost = 0;

        for (Item item : items) {
            if (item.getSKU().startsWith(prefix) && item.getCost() > maxCost) {
                indexItem = items.indexOf(item);
                maxCost = item.getCost();
            }
        }
        return indexItem;
    }

}
