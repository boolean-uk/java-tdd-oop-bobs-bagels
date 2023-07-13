package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private List<String> items;
    private Inventory inventory;
    private int capacity;

    Bagle bagle;

    public Basket(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        inventory = new Inventory();
    }

    public List<String> getItems() {
        return items;
    }

    public boolean addItem(String item) {
        if(inventory.checkAvailability(item) == true && items.size()<capacity) {
            System.out.println("The product added to basket costs :" + inventory.getItemPrice(item));
            items.add(item);
            return true;
        }else {
            return false;
        }

    }
    /*
List<Bagle> bagles;
    public void addFilling(String SKUofBagle,String SKUofFilling) {
        double price = inventory.getItemPrice(SKUofBagle);
        //String variant = inventory.getVariantBySKU(SKUofBagle);
        //if(bagles.contains(bagle)){
        //    bagle.addFilling(SKUofFilling);
        //}
       // bagle = new Bagle(SKUofBagle, price, variant);
        //bagle.addFilling(SKUofFilling);
    }
*/
    public boolean removeItem(String item) {
        if(items.contains(item)) {
            items.remove(item);
            return true;
        }else {
            return false;
        }
    }

    public void changeCapacity(int newCapacity) {
        if(newCapacity > 0 && newCapacity >= items.size()) {
            this.capacity = newCapacity;
        }else if(newCapacity < items.size()) {
            System.out.println("You already got " + items.size() + " bagles in basket so you can't downsize basket to " + newCapacity + " spaces.");
            System.out.println("New basket size is " + items.size());
            this.capacity = items.size();
        }

    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for(String item : items) {
            totalPrice +=inventory.getItemPrice(item);
        }
        return totalPrice;
    }

}
