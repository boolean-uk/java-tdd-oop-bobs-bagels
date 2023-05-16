package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    private int capacity;
    private Inventory inventory;

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
        double total = 0.0;
        for (Item item : this.getItems()) {
            if(item instanceof Bagel){

            }
        }
        return total;
    }

}