package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> itemBasket;
    protected Inventory inventory;
    private int basketSize;

    public Basket(Inventory inventory, int basketSize) {
        this.itemBasket = new ArrayList<>();
        this.basketSize = basketSize;
        this.inventory = inventory;
    }

    public int getBasketSize() {
        return basketSize;
    }

    public ArrayList<Item> getItemBasket() {
        return itemBasket;
    }

    public boolean addToBasket(Item item) {
        if (itemBasket.size() < this.basketSize) {
            itemBasket.add(item);
            return true;
        } else {
            return false;
        }
    }
    public boolean removeFromBasket(Item item) {
        if (itemBasket.contains(item)) {
            itemBasket.remove(item);
            return true;
        }
        return false;
    }

    public boolean addToBasketSize(int changeBasketSize) {
        int newBasketSize = this.basketSize + changeBasketSize;
        if (newBasketSize < 1) {
            return false;
        } else {
            this.basketSize = newBasketSize;
            return true;
        }
    }

    public double getTotalCost() {
        double totalCosts = 0d;
        for (Item item : itemBasket) {
            totalCosts += item.getPrice();
        }
        return totalCosts;
    }
}
