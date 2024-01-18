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
                this.basketContent.replace(item, this.basketContent.get(item) + 1);
            }
            else {
                this.basketContent.put(item, 1);
            }
            HashMap<Item, Integer> tempInventory = this.shop.getInventory();
            tempInventory.replace(item, tempInventory.get(item) - 1);
            this.shop.setInventory(tempInventory);
            return "Item " + item.getSku() + " added to basket.";
        }
    }

    public String remove(Item item) {
        if (this.basketContent.containsKey(item)) {
            if (this.basketContent.get(item) == 1) {
                this.basketContent.remove(item);
            }
            else {
                this.basketContent.replace(item, this.basketContent.get(item) - 1);
            }
            HashMap<Item, Integer> tempInventory = this.shop.getInventory();
            tempInventory.replace(item, tempInventory.get(item) + 1);
            this.shop.setInventory(tempInventory);
            return "Item " + item.getSku() + " removed from basket.";
        }
        else {
            return "Item " + item.getSku() +" not in basket.";
        }
    }

    public double totalCost() {
        if (this.basketContent.isEmpty()){
            return 0.0;
        }
        else {
            double totalPrice = 0.0;
            for (Item item : this.basketContent.keySet()) {
                totalPrice += (item.getPrice() * this.basketContent.get(item));
            }
            return totalPrice;
        }
    }

    public int checkSize() {
        int size = 0;
        for (Item item : this.basketContent.keySet()) {
            size += this.basketContent.get(item);
        }
        return size;
    }

    public String changeCapacity(int newCapacity) {
        if (newCapacity < 0) {
            return "New capacity must be non negative.";
        }
        else if (newCapacity >= this.checkSize()) {
            this.basketCapacity = newCapacity;
            return "New basket capacity is " + newCapacity +".";
        }
        else {
            return "New capacity must be larger than number of items currently in basket.";
        }
    }
}
