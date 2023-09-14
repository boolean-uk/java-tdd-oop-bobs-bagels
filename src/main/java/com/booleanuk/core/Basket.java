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

    public ArrayList<InventoryItem> getItemBasket() {
        return itemBasket;
    }

    public boolean addToBasket(InventoryItem item) {
        if (itemBasket.size() < this.basketSize) {
            itemBasket.add(item);
            System.out.println("Item added successfully" + " " + getItemBasket());
            System.out.println(itemBasket.toString());
            return true;
        } else {
            System.out.println("Basket is full" + " " + itemBasket.size());
            System.out.println(itemBasket.toString());
            return false;
        }
    }
}

