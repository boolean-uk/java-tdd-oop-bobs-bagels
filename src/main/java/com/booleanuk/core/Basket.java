package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<InventoryItem> itemBasket;
    private Inventory inventory;
    private int basketSize;

    public Basket(Inventory inventory, int basketSize) {
        this.itemBasket = new ArrayList<>();
        this.basketSize = basketSize;
        this.inventory = inventory;
    }

    public int getBasketSize() {
        return basketSize;
    }

    public ArrayList<InventoryItem> getItemBasket() {
        return itemBasket;
    }

    public boolean addToBasket(InventoryItem item) {
        if (itemBasket.size() < this.basketSize) {
            itemBasket.add(item);
            System.out.println("Item added successfully" + " " + getItemBasket());
            return true;
        } else {
            System.out.println("Basket is full" + " " + itemBasket.size());
            return false;
        }
    }
    public boolean removeFromBasket(InventoryItem item) {
        if (itemBasket.contains(item));
        itemBasket.remove(item);
        System.out.println("Item removed from basket" + " " + getItemBasket());
        return true;
    }
}

