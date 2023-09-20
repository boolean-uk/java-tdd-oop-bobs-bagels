package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public class Basket {
    int capacity;
    ArrayList<Foods> basketList;
    Inventory inventory = new Inventory();

    public Basket(int capacity) {
        this.capacity = capacity;
        basketList = new ArrayList<>();
    }

    public boolean add(Foods item) {
        if (basketList.size() >= this.capacity) {
            return false;
        }
        if (!this.inventory.inventoryList.containsKey(item.getSku())) {
            return false;
        }
        this.basketList.add(item);
        return true;
    }
    public boolean addMultiple(Foods item, int quantity) {
        if (basketList.size() + quantity > this.capacity) {
            return false;
        }
        if (!this.inventory.inventoryList.containsKey(item.getSku())) {
            return false;
        }
        for (int i=1; i <= quantity;i++) {
            this.basketList.add(item);
        }
        return true;
    }

    public Boolean remove(String sku) {
        for (Foods food:basketList) {
            if (food.getSku().equals(sku)){
                basketList.remove(food);
                return true;
            }
        }
        return false;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public double getTotalCost() {
        int cost = 0;
        for (Foods food: basketList) {
            cost += food.getPrice();
        }
        cost = cost - onionBagelDiscount() - plainBagelDiscount() - EverythingBagelDiscount();
        return (double) (cost / 100.0);
    }


    public int onionBagelDiscount(){
        int oldCost = 0;
        int discount = 0;
        int instances = 0;
        for (Foods food: basketList) {
            if (food.getSku().equals("BGLO")) {
                oldCost += food.getPrice();
                instances ++;
            }
            //    costAfterDiscount = oldCost - discount =>
            // => discount = oldCost - costAfterDiscount
            if (instances >= 6 && instances % 6 == 0){
                discount += oldCost - 249;
                oldCost = 0;
            }
        }
        return discount ;
    }

    public int plainBagelDiscount() {
        int oldCost = 0;
        int discount = 0;
        int instances = 0;
        for (Foods food: basketList) {
            if (food.getSku().equals("BGLP")) {
                oldCost += food.getPrice();
                instances++;
            }
            if (instances >= 12 && instances % 12 == 0){
                discount += oldCost - 399;
                oldCost = 0;
            }
        }
        return discount;
    }

    public int EverythingBagelDiscount(){
        int oldCost = 0;
        int discount = 0;
        int instances = 0;
        for (Foods food: basketList) {
            if (food.getSku().equals("BGLE")) {
                oldCost += food.getPrice();
                instances ++;
            }
            //    costAfterDiscount = oldCost - discount =>
            // => discount = oldCost - costAfterDiscount
            if (instances >= 6 && instances % 6 == 0){
                discount += oldCost - 249;
                oldCost = 0;
            }
        }
        return discount ;
    }


}
