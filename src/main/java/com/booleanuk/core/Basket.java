package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    Inventory inventory;
    int basketCapacity;

    public Basket() {
        this.items = new ArrayList<>();
        this.basketCapacity = 3;
        this.inventory = new Inventory();
    }

//    public boolean addItem(String sku){
//        if (this.items.size() < this.basketCapacity){
//            this.items.add(inventory.getItem(sku.toUpperCase()));
//            return true;
//        }
//        System.out.println("Basket is full, could not add bagel!");
//        return false;
//    }

//    public boolean removeItem(String sku) {
//        if (this.items.contains(sku)) {
//            this.items.remove(sku);
//            return true;
//        }
//        System.out.println("The bagel does not exist in the basket!");
//        return false;
//    }
//
//    public boolean updateBasketCapacity(int newCapacity) {
//        if(newCapacity <= 0) {
//            System.out.println("Cannot update basket capacity to zero or less.");
//            return false;
//        } else if (newCapacity < this.items.size()) {
//            System.out.println("Cannot update basket capacity to a size smaller than current basket size.");
//            return false;
//        }
//        this.basketCapacity = newCapacity;
//        return true;
//    }

}
