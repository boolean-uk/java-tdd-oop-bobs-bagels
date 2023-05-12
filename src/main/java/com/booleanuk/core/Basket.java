package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    Inventory inventory;
    int basketCapacity;
    int sumCosts;

    public Basket() {
        this.items = new ArrayList<>();
        this.basketCapacity = 3;
        this.inventory = new Inventory();
    }

    public boolean addItem(String sku){
        if (this.items.size() < this.basketCapacity) {
            if (inventory.searchItem(sku) == null){
                System.out.println("Can not add item because this item does not exist!");
                return false;
            } else if(inventory.searchItem(sku).sku.equals(sku)) {
                this.items.add(inventory.searchItem(sku.toUpperCase()));
                sumCosts += (this.inventory.searchItem(sku).price * 100);
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
                sumCosts -= (this.inventory.searchItem(sku).price * 100);
                break;
            }
        }

        if(itemExistsInBasket) {
            this.items.remove(this.inventory.searchItem(sku));
            return true;
        }
            System.out.println("The bagel does not exist in the basket!");
            return false;

    }

    public boolean updateBasketCapacity(int newCapacity) {
        if(newCapacity <= 0) {
            System.out.println("Cannot update basket capacity to zero or less.");
            return false;
        } else if (newCapacity < this.items.size()) {
            System.out.println("Cannot update basket capacity to a size smaller than current basket size.");
            return false;
        }
        this.basketCapacity = newCapacity;
        return true;
    }

    public double totalCost () {
        return (double) (sumCosts / 100.0);
    }

    public double itemPrice(String sku) {
        if(this.inventory.searchItem(sku) == null){
            return 0.00;
        }
        return this.inventory.searchItem(sku).price;
    }

}
