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
        if(item instanceof Bagel bagel) {
            for(Filling filling : bagel.getFillings()) {
                if(!inventory.hasItem(filling)) {
                    return name + " doesn't have " + filling.getName() + " " + filling.getClass().getSimpleName() + ".";
                }
            }
            if(!inventory.hasItem(new Bagel(item.getName()))) {
                return name + " doesn't have " + item.getName() + " " + item.getClass().getSimpleName() + ".";
            }
          //  baskets.get(basketId).addItem(new Bagel(bagel));
        } else {
            if (!inventory.hasItem(item)) {
                return name + " doesn't have " + item.getName() + " " + item.getClass().getSimpleName() + ".";
            }

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

    //TODO: refactor this horrible thing
    public Receipt createReceipt(int basketId) {
        HashMap<Item, Double> prices = new HashMap<>();
        LinkedHashMap<Item, Integer> quantities = new LinkedHashMap<>();

        Basket basket = baskets.get(basketId);

        for(Item item: basket.getItems()) {
            if (item instanceof Bagel) {
                Bagel bagel = new Bagel(item.getName());
                if (!quantities.containsKey(bagel)) {
                    quantities.put(bagel, 1);
                } else {
                    quantities.put(bagel, quantities.get(bagel) + 1);
                }
                for (Filling filling : ((Bagel) item).getFillings()) {
                    if (!quantities.containsKey(filling)) {
                        quantities.put(filling, 1);
                    } else {
                        quantities.put(filling, quantities.get(filling) + 1);
                    }
                }
            } else {
                if (!quantities.containsKey(item)) {
                    quantities.put(item, 1);
                } else {
                    quantities.put(item, quantities.get(item) + 1);
                }
            }
        }

        for(Map.Entry<Item, Integer> e: quantities.entrySet()) {
            Item item = e.getKey();
            int quantity = e.getValue();
            if (item instanceof Bagel) {
                prices.put(item, inventory.getCostForOfBundleOfBagels((Bagel) item, quantity));
            } else {
                prices.put(item, getCostOfItem(item)*quantity);
            }
        }
        return new Receipt(prices, quantities, getCostOfBasket(basketId), this.name, 28);
    }
}
