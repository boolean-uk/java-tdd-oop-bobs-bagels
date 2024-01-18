package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private HashMap<Bagel, Integer> products;
    private static final Inventory inventory = new Inventory();
    private int maxSize;

    public Basket(){
        this.products = new HashMap<>();
        this.maxSize = 10;
    }

    public boolean add(String id, String[] fillingIds){

        //If there are fillings
        if(Inventory.isBagel(id)){
        //For each fillingId check if its in inventory
        for (String fillingId : fillingIds){
            if(Inventory.isFilling(fillingId)){

            }
        }
        return false;
    }
        return false;
    }

    public boolean add(String id){

        //If theres an invalid id or a filling
        if(!Inventory.isInInventory(id) || Inventory.isFilling(id)){
            return false;
        }
        //If basket is full
        if((this.getTotalAmount() + 1) > maxSize){
            return false;
        }

        // if there is a bagel with the same id
        if(isIdInKeys(id)){
            //int currentAmount = this.products.get();
            //this.products.put(new Bagel(id), currentAmount + 1);
        }else {
            this.products.put(new Bagel(id), 1);
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

    private boolean isIdInKeys(String id){
        for (Bagel bagel : products.keySet()){
            if (bagel.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private int getTotalAmount(){
        int totalAmount = 0;
        for (int amount : this.products.values()){
            totalAmount += amount;
        }
        return totalAmount;
    }

}
