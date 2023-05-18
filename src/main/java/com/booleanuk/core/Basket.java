package com.booleanuk.core;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Item> items;
    private int capacity;
    private Inventory inventory;
    private boolean hasDiscount;

    // Constructors
    public Basket(Inventory inventory) {
        this.setItems(new ArrayList<>());
        this.setInventory(inventory);
        this.setCapacity(5);
    }

    public Basket(Inventory inventory, int capacity) {
        this.setItems(new ArrayList<>());
        this.setInventory(inventory);
        this.setCapacity(capacity);
    }

    // Getters & Setters
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    // Methods
    public boolean add(Item order) {
        if (!(this.getItems().size() < this.getCapacity())) {
            System.out.println("Could not add item, basket is full.");
            return false;
        }

        for (Item item : getInventory().getInventoryList()) {
            if (item.getSku().equals(order.getSku())) {
                this.getItems().add(item);
                System.out.println("Item added to basket.");
                return true;
            }
        }
        System.out.println("Sorry, we don't have this item.");
        return false;
    }

    public boolean remove(Item order){
        for (Item item : getInventory().getInventoryList()) {
            if (item.getSku().equals(order.getSku())) {
                this.getItems().remove(item);
                System.out.println("Item removed from basket.");
                return true;
            }
        }
        System.out.println("This item does not exist in basket");
        return false;
    }

    public boolean changeCapacity(int newCapacity){
        if (newCapacity <= 0){
            System.out.println("Cannot set the capacity lower than zero");
            return false;
        }
        this.setCapacity(newCapacity);
        return true;
    }

    public double getTotal(){
       return getTotalCosts();

    }

    public HashMap<Item, Integer> getAmountOfItems() {
        HashMap<Item, Integer> items = new HashMap<>();
        for (Item item : getItems()){
            if (!items.containsKey(item)){
            items.put(item, 1);
            } else {
                items.computeIfPresent(item, (k, v) -> v + 1);
            }
        }
        return items;
    }


    // Write a method that calculates discounted price for bagels if there are 12 or more bagels in the basket
    public double getTotalCosts(){
        double total = 0;
        HashMap<Item, Integer> items = new HashMap<>();
        items = getAmountOfItems();

        for (Item item : items.keySet()){
            int quantity = items.get(item);
            if (item instanceof Bagel){
                if (quantity >= 12) {
                    total += 3.99 * ((quantity) / 12);
                    quantity = quantity % 12;
                    items.replace(item, quantity);
                }
                if ( quantity >= 6){
                    total += 2.49 * ((quantity) / 6);
                    quantity = quantity % 6;
                    items.replace(item, quantity);
                }
            }
                total += item.getPrice() * items.get(item);
        }
        return (double) Math.round(total * 100) / 100;
    }
    // Write a method that calculates discounted price for coffee if there are 6 or more coffees in the basket
}