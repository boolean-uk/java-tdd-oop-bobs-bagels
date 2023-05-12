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

    public boolean addItem(String sku){
        if (this.items.size() < this.basketCapacity) {
            if (inventory.getItem(sku) == null){
                System.out.println("Can not add item because this item does not exist!");
                return false;
            } else if(inventory.getItem(sku).sku.equals(sku)) {
                this.items.add(inventory.getItem(sku.toUpperCase()));
                return true;
            }
        System.out.println("Basket is full, could not add bagel!");
        }
            return false;
    }

    public boolean removeItem(String sku) {
        boolean itemExistsInBasket = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).sku.equals(sku)) {
                itemExistsInBasket = true;
                break;
            }
        }

        if(itemExistsInBasket) {
            this.items.remove(this.inventory.getItem(sku));
            return true;
        }
            System.out.println("The bagel does not exist in the basket!");
            return false;

    }

    public boolean updateBasketCapacity(int newCapacity) {
        if(newCapacity <= 0) {
            System.out.println("Cannot update basket capacity to zero or less.");
            return false;
        }
//        else if (newCapacity < this.items.size()) {
//            System.out.println("Cannot update basket capacity to a size smaller than current basket size.");
//            return false;
//        }
        this.basketCapacity = newCapacity;
        return true;
    }

}
