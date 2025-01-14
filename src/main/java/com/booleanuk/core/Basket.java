package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Basket {
    ArrayList<Item> items;
    protected int capacity = 20;

    public Basket() {
        items = new ArrayList<>();
    }

    public boolean addItem(SKU sku) {

        // if no capacity, return false
        if(items.size() >= capacity) {
            basketIsFullMessage();
            return false;
        }

        // add Bagel
        if(sku == SKU.BGLE || sku == SKU.BGLO || sku == SKU.BGLP || sku == SKU.BGLS) {
            items.add(new Bagel(sku));
        }
        // add Coffee
        else if (sku == SKU.COFB || sku == SKU.COFW || sku == SKU.COFC || sku == SKU.COFL) {
            items.add(new Coffee(sku));
        }
        // add Filling
        else if(sku == SKU.FILB || sku == SKU.FILC || sku == SKU.FILE ||
                sku == SKU.FILH || sku == SKU.FILS || sku == SKU.FILX) {
            items.add(new Filling(sku));
        }
        // SKU not recognized, return false
        else {
            System.out.println("SKU doesn't exist in catalog.");
            return false;
        }
        return true;
    }

    boolean removeBagel(SKU SKU) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).SKU == SKU) {
                items.remove(i);
                return true;
            }
        }
        itemNotInBasket();
        return false;
    }

    public void basketIsFullMessage() {
        System.out.println("Basket is full.");
    }

    public void itemNotInBasket() {
        System.out.println("Couldn't find that item in your basket.");
    }

    public float calculateCost() {
        float totalCost = 0F;
        for(Item item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public boolean setCapacity(int capacity) {
        if(capacity > 0) {
            this.capacity = capacity;
            return true;
        }
        System.out.println("Invalid capacity entered.");
        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
