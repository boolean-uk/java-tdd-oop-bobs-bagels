package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Item, Integer> basketContent;
    private int basketCapacity;
    private BobsBagelsShop shop;

    public Basket(BobsBagelsShop shop, int basketCapacity) {
        this.basketContent = new HashMap<>();
        this.basketCapacity = basketCapacity;
        this.shop = shop;
    }

    public HashMap<Item, Integer> getBasketContent() {
        return this.basketContent;
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public String add(Item item) {
        if (this.getBasketContent().size() >= this.getBasketCapacity()) {
            return "Basket is full.";
        }
        else if (!this.shop.getInventory().containsKey(item)) {
            return "Chosen item not in stock.";
        }
        else {
            if (this.basketContent.containsKey(item)){
                this.basketContent.replace(item,this.basketContent.get(item) + 1);
            }
            else {
                this.basketContent.put(item, 1);
            }
            return "Item " + item.getSku() + " added to basket.";
        }
    }

    public void remove(Item item) {

    }

    public double totalCost() {
        return 0.0;
    }

    public String changeCapacity(int newCapacity) {
        return "";
    }
}
