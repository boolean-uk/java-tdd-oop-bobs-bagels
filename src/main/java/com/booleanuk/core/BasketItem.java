package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasketItem {
    private InventoryItem item;
    private ArrayList<InventoryItem> addOns;
    private double price;
    private Inventory inventory = new Inventory();


    public BasketItem(InventoryItem item,  ArrayList<InventoryItem> addOns){
        //System.out.println(addOns);
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

    public void addAddon(String itemSku) {
        InventoryItem item = inventory.getInventoryItemDetails(itemSku);
        if (this.item.getName() == "Bagel") {
            if (item != null) {
                if (item.getName() == "Filling") {
                    this.addOns.add(item);
                } else {
                    System.out.println("This item is not a filling.");
                }

            } else {
                System.out.println("We do not stock this item.");
            }

        }
    }
    public double getPrice() {
        return price;
    }

    public ArrayList<InventoryItem> getAddOns() {
        return addOns;
    }
    public InventoryItem getItem(){
        return this.item;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item.getVariant() + " "+ item.getName());
        if (!addOns.isEmpty()) {
            sb.append(" + ");
            for (InventoryItem addOn : addOns) {
                sb.append(addOn.getName()).append(", ");
            }
            // Remove trailing comma and space
            sb.setLength(sb.length() - 2);
        }
        sb.append(" | $").append(price);
        return sb.toString();
    }

}
