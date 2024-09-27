package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<InventoryItem> itemBasket;
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

    public ArrayList<InventoryItem> getItemBasket() {
        return itemBasket;
    }

    public boolean addToBasket(InventoryItem item) {
        if (itemBasket.size() < this.basketSize) {
            itemBasket.add(item);
//            System.out.println("Item added successfully" + " " + getItemBasket());
            return true;
        } else {
//            System.out.println("Basket is full" + " " + itemBasket.size());
            return false;
        }
    }
    public boolean removeFromBasket(InventoryItem item) {
        if (itemBasket.contains(item)) {
            itemBasket.remove(item);
//            System.out.println("Item removed from basket" + " " + getItemBasket());
            return true;
        }
//        System.out.println("Item is not in basket and can't be removed" + " " + getItemBasket());
        return false;
    }

    public boolean addToBasketSize(int changeBasketSize) {
        int newBasketSize = this.basketSize + changeBasketSize;
        if (newBasketSize < 1) {
//            System.out.println("Changing the basket size didn't work" + " " + basketSize);
            return false;
        } else {
            this.basketSize = newBasketSize;
//            System.out.println("Changing basket size is successful" + " " + basketSize);
            return true;
        }
    }

    public double getTotalCost() {
       double totalCosts = 0.00;
       for (InventoryItem item : itemBasket) {
         totalCosts += item.getPrice();
       }
//        System.out.println("The total costs of your items is: " + totalCosts);
    return totalCosts;
    }
}


