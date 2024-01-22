package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//TODO: check upper vs lowercase
public class Store {
    private HashMap<Integer, Basket> baskets;
    private Inventory inventory;
    private int basketCapacity;
    private String name;

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
        baskets.get(basketId).addItem(item);
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
        return baskets.get(basketId).removeItem(item);
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

        Basket basket = baskets.get(basketId);

        for(Item item: basket.getItems()) {
            if (item.containsOtherItems()) {
                for (Item containedItem : item.getContainedItems()) {
                    if (!quantities.containsKey(containedItem)) {
                        quantities.put(containedItem, 1);
                        prices.put(containedItem, getCostOfItem(containedItem));
                        discounts.put(containedItem, 0.0);
                    } else {
                        quantities.put(containedItem, quantities.get(containedItem) + 1);
                        prices.put(containedItem, prices.get(containedItem)+getCostOfItem(containedItem));
                    }
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

        ArrayList<Item> notInBundles = new ArrayList<>(basket.getItems());

        for(Map.Entry<Item, Integer> e: quantities.entrySet()) {
            Item item = e.getKey();
            int quantity = e.getValue();
            double cost = 0;
            if (inventory.hasBundleDiscountForItem(item)) {
                double bundleCost = inventory.getCostForBundle(item, quantity);
                System.out.println(bundleCost);
                if(bundleCost > 0) {
                    prices.put(item, prices.get(item) + bundleCost);
                    int noOfItemsToRemove = quantity - inventory.getRemainderAfterBundle(item, quantity);
                    for (int i = 0; i < noOfItemsToRemove; i++) {
                        notInBundles.remove(item);
                    }
                    double discount = noOfItemsToRemove * getCostOfItem(item) - (discounts.get(item) + bundleCost);
                    discounts.put(item, discount);
                    totalDiscounts += discount;
                }
            }
        }

        for(ArrayList<Item> comboItems: inventory.getComboDiscounts().keySet()) {
            double comboPrice = 0;

            while(inventory.containsComboItems(notInBundles, comboItems)) {
                comboPrice = inventory.getComboDiscounts().get(comboItems);
                double totalOriginalCost = 0;
                Item lastItem = null;
                for(Item comboItem: comboItems) {
                    notInBundles.remove(comboItem);
                    int quantity = quantities.remove(comboItem);
                    quantities.put(comboItem, quantity);
                    lastItem = comboItem;
                    totalOriginalCost += getCostOfItem(comboItem);
                }

                double discount = totalOriginalCost-( discounts.get(comboItems.get(0)) + comboPrice);
                discounts.put(lastItem, discounts.get(lastItem)+discount);
                totalDiscounts += discount;
                prices.put(comboItems.get(0), prices.get(comboItems.get(0)) + comboPrice);

            }
        }

        for(Item item: notInBundles) {
            System.out.println(item);
            prices.put(item, prices.get(item) + getCostOfItem(item));
        }
        if(withDiscountData) {
            return new Receipt(prices, quantities, discounts, getCostOfBasket(basketId), totalDiscounts, this.name, 28);
        } else {
            return new Receipt(prices, quantities, getCostOfBasket(basketId), this.name, 28);
        }
    }

}
