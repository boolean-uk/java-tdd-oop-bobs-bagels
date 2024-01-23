package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.*;

public class Basket {

    private ArrayList<Item> items;
    private HashMap<String, Integer> itemCounterForDiscount;
    private HashMap<Item, Integer> itemCounterForReceipt;
    private double totalCost;
    private Customer customer;

    public Basket(Customer customer) {
        this.items = new ArrayList<>();
        this.totalCost = 0;
        this.customer = customer;
        this.itemCounterForDiscount = new HashMap<>();
        this.itemCounterForReceipt = new HashMap<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public Customer getCustomer() {
        return customer;
    }

    /*
    Updates the prices for the items, according to the given discounts
    Iterates over the updated prices, and adds them together
    return: (double) updatedCostOfAllItemsInBasket
     */
    public double calculateTotalCost() {
        this.items = applyDiscounts();
        for(Item item : items) {
            System.out.println(item);
        }
        this.totalCost = 0;
        if(!this.items.isEmpty()) {
            for(Item item : items) {
                this.totalCost += item.getCost();
            }
        }
        System.out.println("Your total is: £" + String.format("%.2f", totalCost));
        return this.totalCost;
    }

    public String addItem(Item newItem) {
        items.add(newItem);
        return "A new item has been added:\n" + newItem;
    }
    /*
    If basket is empty, do nothing
    If basket has more elements than the new capacity, remove overflowing elements
    If basket has less items than the new capacity, do nothing
     */
    public boolean capacityChanged() {
        if(this.items.isEmpty()) {
            return true;
        }

        if(this.items.size() > customer.getStore().getCapacity()) {
            int itemsToRemove = this.items.size() - customer.getStore().getCapacity();
            for(int i = 0; i < itemsToRemove; i++) {
                this.items.remove(this.items.size()-1);
            }
            return true;
        }

        if(this.items.size() <= customer.getStore().getCapacity()) {
            return true;
        }
        return false;
    }

    public ArrayList<Item> applyDiscounts() {
        ArrayList<Item> tempArray = items;
        tempArray.sort(Comparator.comparing(Item::getSKU));
        double savedMoney = 0;

        // make an HashMap that counts occurrences of items
        for(Item item : tempArray) {
            if(itemCounterForDiscount.containsKey(item.getSKU())) {
                itemCounterForDiscount.put(item.getSKU(), itemCounterForDiscount.get(item.getSKU())+1);
            } else {
                itemCounterForDiscount.put(item.getSKU(), 1);
            }
        }
        // bulk-discount for 12 bagels
        while (itemCounterForDiscount.values().stream().anyMatch(i -> i >= 12)) {
            for (Map.Entry<String, Integer> entry : itemCounterForDiscount.entrySet()) {
                if (itemCounterForDiscount.get(entry.getKey()) >= 12) {
                    itemCounterForDiscount.put(entry.getKey(), itemCounterForDiscount.get(entry.getKey()) - 12);
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
        while (itemCounterForDiscount.values().stream().anyMatch(i -> i >= 6)) {

            for (Map.Entry<String, Integer> entry : itemCounterForDiscount.entrySet()) {
                if (itemCounterForDiscount.get(entry.getKey()) >= 6) {
                    itemCounterForDiscount.put(entry.getKey(), itemCounterForDiscount.get(entry.getKey()) - 6);
                    int indexCounter = 0;

                    for(int i = 0; i < tempArray.size(); i++) {
                        if(tempArray.get(i).getSKU().equals(entry.getKey())) {
                            indexCounter = i;
                            tempArray.get(i).setCost(2.49);
                            tempArray.get(i).setDiscounted(true);
                            break;
                        }
                    }

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
            int quantity = itemCounterForDiscount.get(item.getSKU());
            if (item.getInstance().equals(Bagel.class) && !item.isDiscounted()) {
                remainingBagel += quantity;
            } else if (item.getInstance().equals(Coffee.class) && !item.isDiscounted()) {
                remainingCoffee += quantity;
            }
        }

        while(Math.min(remainingCoffee,remainingBagel) > 0 &&
                findMostExpensiveItemWithPrefix(tempArray, "BGL") != -1 &&
                findMostExpensiveItemWithPrefix(tempArray, "COF") != -1) {

            int bagelToDiscount = findMostExpensiveItemWithPrefix(tempArray, "BGL");
            int coffeeToDiscount = findMostExpensiveItemWithPrefix(tempArray, "COF");
            if (bagelToDiscount != -1) {
                tempArray.get(bagelToDiscount).setCost(0.35);
                tempArray.get(bagelToDiscount).setDiscounted(true);
            }
            if (coffeeToDiscount != -1) {
                tempArray.get(coffeeToDiscount).setCost(0.90);
                tempArray.get(coffeeToDiscount).setDiscounted(true);
            }
            remainingBagel--;
            remainingCoffee--;
        }
        return tempArray;
    }


    /*
    Helper-method for applyDiscount()
    Returns the most expensive item with a SKU containing 'prefix'
     */
    private int findMostExpensiveItemWithPrefix(ArrayList<Item> items, String prefix) {
        int indexItem = -1;
        double maxCost = 0;

        for (Item item : items) {
            if (item.getSKU().startsWith(prefix) && item.getCost() > maxCost && !item.isDiscounted()) {
                indexItem = items.indexOf(item);
                maxCost = item.getCost();
            }
        }
        return indexItem;
    }

    /*
    Prints the receipts for a purchase

    */
    public void showReceipt() {
        System.out.println("\t\t\t ~~~ Bob's Bagels ~~~\n");
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("\t\t\t" + dateFormat.format(currentDate));
        System.out.println("\n----------------------------------------------\n");
        System.out.println(showInventory());
        System.out.println("\n----------------------------------------------");
        calculateTotalCost();
        System.out.println("\nThank you for your order!");
    }

    /*
    Returns a String made for printing all items in Basket to console
     */
    public String showInventory() {
        String inventoryString = "";

        for(Item item : items) {
            if(itemCounterForReceipt.containsKey(item)) {
                itemCounterForReceipt.put(item, itemCounterForReceipt.get(item)+1);
            } else {
                itemCounterForReceipt.put(item, 1);
            }
        }

        if(!this.itemCounterForReceipt.isEmpty()) {
            System.out.println("Quantity\tSKU\t\tCost\tName\tVariant\t\tTotal");
            for(Map.Entry<Item, Integer> item : itemCounterForReceipt.entrySet()) {
                inventoryString += "\t" + item.getValue() + "\t\t" + item.getKey().toString() + "\t\t" + String.format("%.2f", item.getValue()*item.getKey().getCost())+ "\n";
            }
        }
        if(inventoryString.isEmpty()) {
            inventoryString = "There are no items in basket... ";
        }
        return inventoryString;
    }
}
