package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemHandler {

    private ArrayList<Item> basket;
    private int basketCapacity;
    private HashMap<String, String> allItems;
    private int idTracker;

    public ItemHandler() {
        this.idTracker = 0;
        this.basketCapacity = 1;
        this.basket = new ArrayList<>();
        setUpAllItems();
    }

    public Item addBasicItem(String SKU) {
        if (this.allItems.get(SKU).equals("Bagel")) {
            Bagel bagel = new Bagel(SKU, idTracker);
            idTracker++;
            basket.add(bagel);
            System.out.println(bagel.getName() + ", " + bagel.getVariant() + ", price: " + bagel.getPrice());
            return bagel;
        } else if (this.allItems.get(SKU).equals("Coffee")) {
            Coffee coffee = new Coffee(SKU, idTracker);
            idTracker++;
            basket.add(coffee);
            System.out.println(coffee.getName() + ", " + coffee.getVariant() + ", price: " + coffee.getPrice());
            return coffee;
        }
        System.out.println("No such bagel or coffee exists.");
        return null;
    }

    public void setUpAllItems() {
        this.allItems = new HashMap<>();
        this.allItems.put("BGLO", "Bagel");
        this.allItems.put("BGLP", "Bagel");
        this.allItems.put("BGLE", "Bagel");
        this.allItems.put("BGLS", "Bagel");

        this.allItems.put("COFB", "Coffee");
        this.allItems.put("COFW", "Coffee");
        this.allItems.put("COFC", "Coffee");
        this.allItems.put("COFL", "Coffee");

        this.allItems.put("FILB", "Filling");
        this.allItems.put("FILE", "Filling");
        this.allItems.put("FILC", "Filling");
        this.allItems.put("FILX", "Filling");
        this.allItems.put("FILS", "Filling");
        this.allItems.put("FILH", "Filling");
    }

    public ArrayList<Item> getBasket() {
        return basket;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public HashMap<String, String> getAllItems() {
        return allItems;
    }

    public int getIdTracker() {
        return idTracker;
    }
}
