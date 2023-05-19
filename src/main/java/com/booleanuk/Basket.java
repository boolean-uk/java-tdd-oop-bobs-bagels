package com.booleanuk;

import java.util.*;
import java.util.stream.Collectors;

public class Basket {

    private final Receipt receipt;
    private final Inventory inventory;
    private int capacity;

    public Basket(int capacity, Inventory inventory, Receipt receipt) {
        this.capacity = capacity;
        this.inventory = inventory;
        this.receipt = receipt;
    }

    private boolean canAddToCart() {
        return receipt.numberOfItems() < capacity;
    }

    public boolean add(Bagel bagel){
        if (!inventory.contains(bagel)) return false;

        if (!canAddToCart()) return false;

        receipt.add(bagel);
        return true;
    }

    public boolean add(Coffee coffee){
        if (!inventory.contains(coffee)) return false;

        if (!canAddToCart()) return false;

        receipt.add(coffee);
        return true;
    }

    public boolean remove(Bagel bagel){
        return receipt.remove(bagel);
    }

    public boolean remove(Coffee coffee){
        return receipt.remove(coffee);
    }

    public boolean updateCapacity(int capacity){
        if(receipt.numberOfItems() >= capacity) return false;

        this.capacity = capacity;

        return true;
    }


    public double discountedCost() {
       return receipt.discountedCost();
    }

    public String receipt() {
        return receipt.asString();
    }


}
