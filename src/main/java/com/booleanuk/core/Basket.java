package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private double totalCost;
    private Customer customer;

    public Basket(Customer customer) {
        this.items = new ArrayList<>();
        this.totalCost = 0;
        this.customer = customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public Customer getCustomer() {
        return customer;
    }

    public double calculateTotalCost() {
        if(!this.items.isEmpty()) {
            for(Item item : items) {
                this.totalCost += item.getCost();
            }
        }
        System.out.println("Your total is: " + this.totalCost);
        return this.totalCost;
    }

    public Item addItem(Item newItem) {
        return new Item("", -1, "", "");
    }

    public boolean capacityChanged() {
        // if basket is empty, do nothing, return true
        if(this.items.isEmpty()) {
            return true;
        }
        // if basket has more elements than capacity, remove overflowing elements, return true
        if(this.items.size() > customer.getStore().getCapacity()) {
            int itemsToRemove = this.items.size() - customer.getStore().getCapacity();
            for(int i = 0; i < itemsToRemove; i++) {
                this.items.remove(this.items.size()-1);
            }
            return true;
        }
        // if basket has less or same number of elements than capacity, do nothing, return true
        if(this.items.size() <= customer.getStore().getCapacity()) {
            return true;
        }
        // if something else, return false
        return false;
    }

}
