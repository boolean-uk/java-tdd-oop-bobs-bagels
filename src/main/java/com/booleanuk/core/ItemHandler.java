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

    public Bagel addBagel(String SKU) {
        if (this.basket.size() >= this.basketCapacity) {
            System.out.println("Basket is full.");
            return null;
        }
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Bagel")) {
            Bagel bagel = new Bagel(SKU, idTracker);
            this.idTracker++;
            this.basket.add(bagel);
            System.out.println(bagel.getName() + ", " + bagel.getVariant() + ", price: " + bagel.getPrice());
            return bagel;
        }
        System.out.println("No such bagel exists.");
        return null;
    }

    public Coffee addCoffee(String SKU) {
        if (this.basket.size() >= this.basketCapacity) {
            System.out.println("Basket is full.");
            return null;
        }
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Coffee")) {
            Coffee coffee = new Coffee(SKU, idTracker);
            this.idTracker++;
            this.basket.add(coffee);
            System.out.println(coffee.getName() + ", " + coffee.getVariant() + ", price: " + coffee.getPrice());
            return coffee;
        }
        System.out.println("No such coffee exists.");
        return null;
    }

    public Filling addFilling(String SKU, Bagel bagel) {
        if (this.allItems.containsKey(SKU) && this.allItems.get(SKU).equals("Filling")) {
            if (basket.contains(bagel)) {
                Filling filling = new Filling(SKU, idTracker, bagel);
                idTracker++;
                System.out.println(filling.getName() + ", " + filling.getVariant() + ", price: " + filling.getPrice());
                return filling;
            } else {
                System.out.println("No such bagel exists in the basket.");
                return null;
            }
        } else {
            System.out.println("No filling exists with that SKU.");
            return null;
        }
    }

    public boolean removeItem(int id) {
        for (int i = 0; i < this.basket.size(); i++) {
            if (this.basket.get(i).getId() == id) {
                this.basket.remove(i);
                return true;
            } else if (this.basket.get(i) instanceof Bagel) {
                if (this.basket.get(i).removeFilling(id)) {
                    return true;
                }
            }
        }
        System.out.println("No such item was found.");
        return false;
    }

    public boolean setCapacity(int newCapacity) {
        if (this.basket.size() > newCapacity) {
            System.out.println("Capacity cant be smaller than the current size of the basket");
            return false;
        }
        this.basketCapacity = newCapacity;
        return true;
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

    public double getTotal() {
        double total = 0;
        for (Item item : basket) {
            total += item.getPrice();
        }
        return total;
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
