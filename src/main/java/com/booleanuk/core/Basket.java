package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    ArrayList<Product> basket;
    int size;
    public Basket(int size){
        this.basket = new ArrayList<>();
        this.size = size;
    }
    public boolean add(Product item){
       if(this.basket.contains(item)){
           System.out.println(item +" already added!");
           return false;
       }
       this.basket.add(item);
       System.out.println(item + " added successfully!");
       return true;

    }
    public String remove(Product item){
        if(this.basket.isEmpty()){
            return "Basket is empty";
        }
        this.basket.remove(item);
        return item +" removed from basket";
    }
    public boolean isFull(){
        if( this.basket.size() >= size){
            System.out.println("Basket is full");
            return true;
        }
        return false;
    }
    public String changeCapacity(int newCapacity){
        this.basket.ensureCapacity(newCapacity);
        return "Basket size is updated to " + newCapacity;
    }

    public double getTotalCost(){

}
