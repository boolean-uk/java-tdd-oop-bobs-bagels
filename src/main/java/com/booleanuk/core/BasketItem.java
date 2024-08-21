package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasketItem {
    private InventoryItem item;
    private ArrayList<InventoryItem> addOns;
    private double price;



    public BasketItem(InventoryItem item,  ArrayList<InventoryItem> addOns){
        System.out.println(addOns);
        this.item = item;
        this.addOns = addOns;
        double sum = 0.0;
        for(InventoryItem loopie : addOns){
            sum += loopie.getPrice();
        }
        this.price = item.getPrice() + sum;
    }

    public BasketItem(InventoryItem item){
        this.item = item;
        this.addOns = new ArrayList<>();
        this.price = item.getPrice();
    }



    public double getPrice() {
        return price;
    }

    public ArrayList<InventoryItem> getAddOns() {
        return addOns;
    }
}
