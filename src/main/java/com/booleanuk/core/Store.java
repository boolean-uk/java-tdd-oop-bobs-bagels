package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Store {
    private HashMap<Integer, Basket> baskets;
    private Inventory inventory;
    private int basketCapacity;
    private String name;

    public Store(int basketCapacity, Inventory inventory, String name) {
        baskets = new HashMap<>();
        this.basketCapacity = basketCapacity;
        this.inventory = inventory;
        this.name = name;
    }

    //Specifically for Bob's Bagels
    public Store() {
        baskets = new HashMap<>();
        basketCapacity = 3;
        inventory = new Inventory();
        name = "Bob's Bagels";
    }

    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    //for the tests
    public HashMap<Integer,Basket> getBaskets() {
        return new HashMap<>(baskets);
    }

    public String addItemToBasket(Item item, int basketId) {
        Basket basket = baskets.get(basketId);

        if(basket.getNoOfItems() >= basketCapacity) {
            return "You're basket is full!";
        }

        if(item.containsOtherItems()) {
            for(Item containedItem : item.getContainedItems()) {
                if(!inventory.hasItem(containedItem)) {
                    return name + " doesn't have " + containedItem.getName() + " " + containedItem.getClass().getSimpleName() + ".";
                }
            }
        }

        if (!inventory.hasItem(item)) {
            return name + " doesn't have " + item.getName() + " " + item.getClass().getSimpleName() + ".";
        }

        baskets.get(basketId).add(item);
        return item.getName() + " " + item.getClass().getSimpleName() + " added.";
    }

    public boolean updateBasketCapacity(int newCapacity) {
        for(Basket basket: baskets.values()) {
            if(basket.getNoOfItems()> newCapacity) {
                return false;
            }
        }
        basketCapacity = newCapacity;
        return true;
    }

    public double getCostOfItem(Item item) {
        return inventory.getCostOfItem(item);
    }

    public double getCostOfBasket(int basketId) {
        return inventory.getCostOfBasket(baskets.get(basketId));
    }

    //TODO: what do if nonexistent basketid
    public boolean removeItemFromBasket(Item item, int basketId) {
        return baskets.get(basketId).remove(item);
    }

    public Receipt createReceiptWithDiscountData(int basketId) {
        return createReceipt(basketId, true);
    }

    public Receipt createReceipt(int basketId) {
        return createReceipt(basketId, false);
    }
    private Receipt createReceipt(int basketId, boolean withDiscountData) {
        HashMap<Item, Double> prices = new HashMap<>();
        LinkedHashMap<Item, Integer> quantities = new LinkedHashMap<>();
        HashMap<Item, Double> discounts = new HashMap<>();
        double totalDiscounts = 0;
        double totalCost = 0;

        Basket basket = baskets.get(basketId);

        //initialise product data maps
        for(Item item: basket.getItems()) {
            if (item.containsOtherItems()) {
                for (Item containedItem : item.getContainedItems()) {
                    double cost = getCostOfItem(containedItem);
                    if (!quantities.containsKey(containedItem)) {
                        quantities.put(containedItem, 1);
                        prices.put(containedItem, cost);
                        discounts.put(containedItem, 0.0);
                    } else {
                        quantities.put(containedItem, quantities.get(containedItem) + 1);
                        prices.put(containedItem, prices.get(containedItem) + cost);
                    }
                    totalCost += cost;
                }
            }
            if (!quantities.containsKey(item)) {
                quantities.put(item, 1);
                prices.put(item, 0.0);
                discounts.put(item, 0.0);
            } else {
                quantities.put(item, quantities.get(item) + 1);
            }

        }

        ArrayList<Item> itemsWithNoDiscounts = new ArrayList<>(basket.getItems());

        //add data for products with active bundle discounts and remove them from itemsWithNoDiscounts
        for(Map.Entry<Item, Integer> e: quantities.entrySet()) {
            Item item = e.getKey();
            int quantity = e.getValue();
            if (inventory.hasBundleDiscountForItem(item)) {
                double bundleCost = inventory.getCostOfBundle(item, quantity);
                if(bundleCost > 0) {
                    prices.put(item, prices.get(item) + bundleCost);
                    totalCost += bundleCost;
                    int noOfItemsToRemove = quantity - inventory.getNoOfItemsRemainingAfterBundleDiscounts(item, quantity);
                    for (int i = 0; i < noOfItemsToRemove; i++) {
                        itemsWithNoDiscounts.remove(item);
                    }
                    double discount = noOfItemsToRemove * getCostOfItem(item) - (discounts.get(item) + bundleCost);
                    discounts.put(item, discount);
                    totalDiscounts += discount;
                }
            }
        }

        //add data for products with active combo discounts and remove them from itemsWithNoDiscounts
        for(ArrayList<Item> comboItems: inventory.getComboDiscounts().keySet()) {
            double comboPrice;

            while(itemsWithNoDiscounts.containsAll(comboItems)) {
                comboPrice = inventory.getComboDiscounts().get(comboItems);
                double totalOriginalCost = 0;
                Item lastItem = null;
                for(Item comboItem: comboItems) {
                    itemsWithNoDiscounts.remove(comboItem);
                    int quantity = quantities.remove(comboItem);
                    quantities.put(comboItem, quantity);
                    lastItem = comboItem;
                    totalOriginalCost += getCostOfItem(comboItem);
                }

                double discount = totalOriginalCost-( discounts.get(comboItems.get(0)) + comboPrice);
                discounts.put(lastItem, discounts.get(lastItem)+discount);
                totalDiscounts += discount;
                prices.put(comboItems.get(0), prices.get(comboItems.get(0)) + comboPrice);
                totalCost += comboPrice;

            }
        }

        //add price for all items that are not part of discount or contained in other items
        for(Item item: itemsWithNoDiscounts) {
            prices.put(item, prices.get(item) + getCostOfItem(item));
            totalCost += getCostOfItem(item);
        }

        if(withDiscountData) {
            return new Receipt(prices, quantities, discounts, totalCost, totalDiscounts, this.name, 28);
        } else {
            return new Receipt(prices, quantities, totalCost, this.name, 28);
        }
    }

}
