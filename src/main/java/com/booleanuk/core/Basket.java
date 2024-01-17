package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    ArrayList<String> basket;
    public int capacity;

    public Basket(){
        this.basket = new ArrayList<>();
        this.capacity = 5;
    }

    public boolean checkIfNotFull(){
        if(this.basket == null){
            return false;
        }
        if(this.basket.size() > this.capacity){
            System.out.println("Basket is full, unable to add bagel!");
            return false;
        }
        System.out.println("Basket is not full, adding bagel");
        return true;
    }

    public String tryRemoveBagel(String bagel){
        if (!this.basket.contains(bagel)) {
            System.out.println("Bagel not in list");
            return "Bagel not in list";
        }
        System.out.println("Bagel is removed from list");
        this.basket.remove(bagel);
        return "Bagel is removed from list";
    }
    public int changeCapacity(int capacity){
        if(capacity < 0 ){
            System.out.println("Invalid capacity, setting default capacity of 5");
            return this.capacity = 5;
        }
        return this.capacity = capacity;
    }
    public boolean remove(String bagel) {
        if(bagel == null){
            return false;
        }
        if(!this.basket.contains(bagel)){
            return false;
        }
        this.tryRemoveBagel(bagel);
        return true;
    }



    public boolean add(String bagel){
        if(bagel == null){
            return false;
        }
        if(bagel.isEmpty()){
            return false;
        }
        if(checkIfNotFull()){
            basket.add(bagel);
        }
        return true;
    }

}
