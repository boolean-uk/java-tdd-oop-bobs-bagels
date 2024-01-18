package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private HashMap<String, Integer> products;
    private static final Inventory inventory = new Inventory();
    private int maxSize;

    public Basket(){
        this.products = new HashMap<>();
        this.maxSize = 10;
    }

    public boolean add(String id){
        if(!inventory.isInInventory(id) || inventory.isFilling(id)){
            return false;
        }
        if((this.getTotalAmount() + 1) > maxSize){
            return false;
        }
        if(products.containsKey(id)){
            int currentAmount = this.products.get(id);
            this.products.put(id, currentAmount + 1);
        }else {
            this.products.put(id, 1);
        }
        return true;
    }

    public boolean remove(String id){
        return false;
    }

    public String setMaxSize(int max){
        this.maxSize = max;
        return "";
    }

    public int getTotalAmount(){
        int totalAmount = 0;
        for (int amount : this.products.values()){
            totalAmount += amount;
        }
        return totalAmount;
    }
}
