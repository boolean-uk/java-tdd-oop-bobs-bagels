package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Basket {

    ArrayList<Bagel> basket;
    double total;
    int capacity;
    public Basket(){
        this.basket = new ArrayList<>();
        this.total = 0;
        this.capacity = 5;
    }

    public boolean add(String bagelType){
        Bagel bagel = new Bagel(bagelType);
        if(!bagel.getName().isEmpty()){
            if(!checkIfBasketIsFull()){
                basket.add(bagel);
                System.out.println("Added " + bagel.getName());
                return true;
            }
        }
        System.out.println("Could not add bagel");
        return false;
    }

    public boolean remove(String bagelType){
        for (int i = 0; i < basket.size(); i++) {
            if(Objects.equals(basket.get(i).getName(), bagelType)){
                System.out.println("Removing " + basket.get(i).getName() + " from list");
                basket.remove(basket.get(i));
                return true;
            }
        }
        System.out.println("Bagel not found");
        return false;
    }

    public boolean checkIfBasketIsFull(){
        if(basket.size() >= capacity){
            System.out.println("Basket is full");
            return true;
        }
        System.out.println("Basket is not full");
        return false;
    }

    public void clearList(){
        this.basket.clear();
    }
}
