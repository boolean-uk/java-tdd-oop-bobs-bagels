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

    public Receipt createReceipt2(int basketId) {
        HashMap<Item, Double> prices = new HashMap<>();
        LinkedHashMap<Item, Integer> quantities = new LinkedHashMap<>();

        Basket basket = baskets.get(basketId);

        for(Item item: basket.getItems()) {
            if (item.containsOtherItems()) {
                for (Item containedItem : item.getContainedItems()) {
                    if (!quantities.containsKey(containedItem)) {
                        quantities.put(containedItem, 1);
                    } else {
                        quantities.put(containedItem, quantities.get(containedItem) + 1);
                    }
                }
            }
            if (!quantities.containsKey(item)) {
                quantities.put(item, 1);
            } else {
                quantities.put(item, quantities.get(item) + 1);
            }

        }

        for(Map.Entry<Item, Integer> e: quantities.entrySet()) {
            Item item = e.getKey();
            int quantity = e.getValue();
            if (inventory.hasBundleDiscount(item)) {
                prices.put(item, inventory.getCostForBundle(item, quantity));
            } else {
                prices.put(item, getCostOfItem(item)*quantity);
            }
        }
        return new Receipt(prices, quantities, getCostOfBasket(basketId), this.name, 28);
    }


    public Receipt createReceipt(int basketId) {
        HashMap<Item, Double> prices = new HashMap<>();
        LinkedHashMap<Item, Integer> quantities = new LinkedHashMap<>();

        Basket basket = baskets.get(basketId);

        for(Item item: basket.getItems()) {
            if (item.containsOtherItems()) {
                for (Item containedItem : item.getContainedItems()) {
                    if (!quantities.containsKey(containedItem)) {
                        quantities.put(containedItem, 1);
                        prices.put(containedItem, 0.0);
                    } else {
                        quantities.put(containedItem, quantities.get(containedItem) + 1);
                    }
                }
            }
            if (!quantities.containsKey(item)) {
                quantities.put(item, 1);
                prices.put(item, 0.0);
            } else {
                quantities.put(item, quantities.get(item) + 1);
            }

        }

        ArrayList<Item> notInBundles = new ArrayList<>(basket.getItems());

        for(Map.Entry<Item, Integer> e: quantities.entrySet()) {
            Item item = e.getKey();
            int quantity = e.getValue();
            double cost = 0;
            if (inventory.hasBundleDiscount(item)) {
                prices.put(item, prices.get(item) + inventory.getCostForBundle(item, quantity));
                int noOfItemsToRemove = quantity - inventory.getRemainderAfterBundle(item, quantity);
                for(int i = 0; i < noOfItemsToRemove; i++) {
                    notInBundles.remove(item);
                }
            }
        }

        for(ArrayList<Item> comboItems: inventory.getComboDiscounts().keySet()) {
            int comboPrice = 0;
            System.out.println("jejj "+comboItems);
            System.out.println("ok  "+notInBundles);

            while(inventory.containsComboItems(notInBundles, comboItems)) {
                System.out.println(comboItems);
                comboPrice += inventory.getComboDiscounts().get(comboItems);
                for(Item comboItem: comboItems) {
                    notInBundles.remove(comboItem);
                    int quantity = quantities.remove(comboItem);
                    quantities.put(comboItem, quantity);
                }
                prices.put(comboItems.get(0), prices.get(comboItems.get(0)) + comboPrice);

            }
        }

        for(Item item: notInBundles) {
            prices.put(item, prices.get(item) + getCostOfItem(item));
        }

        return new Receipt(prices, quantities, getCostOfBasket(basketId), this.name, 28);
    }

}
