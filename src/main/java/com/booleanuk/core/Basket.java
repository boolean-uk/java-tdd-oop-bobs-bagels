package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private static int capacity;
    private List<Product> contents;

    public Basket() {
        contents = new ArrayList<>();
    }

    public static void setCapacity(int basketCapacity) {
        capacity = basketCapacity;
    }

    public void addToBasket(Bagel bagel) throws Exception {
        if(contents.size() >= capacity){
            throw new Exception("Basket is full!");
        }
        List<Filling> fillings = bagel.getFillings();
        bagel.setFillings(Collections.emptyList());
        if(!Manager.getInventory().contains(bagel)){
            throw new Exception("Bagel " + bagel + " is not in the manager's inventory!");
        }
        System.out.println(fillings);
        if(!Manager.getInventory().containsAll(fillings)){
            throw new Exception("Bagel does not have the correct filling!");
        }
        bagel.setFillings(fillings);
        contents.add(bagel);
    }

    public void removeFromBasket(Bagel bagel) throws Exception{
        if(!contents.contains(bagel)){
            throw new Exception("Bagel " + bagel +  " is not in the basket!");
        }
        contents.remove(bagel);
    }

    public boolean isBasketFull(){ return contents.size() >= capacity; }

    public List<Product> getContents() {
        return contents;
    }

    public Double getTotalCost(){ return contents.stream().mapToDouble(Product::getPrice).sum(); }

}
