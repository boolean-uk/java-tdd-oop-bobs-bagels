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

    public void addToBasket(Bagel bagel) {
        if(contents.size() >= capacity){
            throw new IllegalStateException("Basket is full!");
        }
        List<Filling> fillings = bagel.getFillings();
        bagel.setFillings(Collections.emptyList());

        if(!Manager.getInventory().contains(bagel)){
            throw new IllegalArgumentException("Bagel " + bagel + " is not in the manager's inventory!");
        }

        if(!Manager.getInventory().containsAll(fillings)){
            throw new IllegalArgumentException("Bagel does not have the correct filling!");
        }

        bagel.setFillings(fillings);
        contents.add(bagel);
    }

    public void removeFromBasket(Bagel bagel) {
        if(!contents.contains(bagel)){
            throw new IllegalArgumentException("Bagel is not in the basket!");
        }
        contents.remove(bagel);
    }

    public boolean isBasketFull(){ return contents.size() >= capacity; }

    public List<Product> getContents() {
        return contents;
    }

    public Double getTotalCost(){
        Double totalCost = 0.0;
        for (Product product: contents) {
            if (product instanceof Bagel bagel) {
                for (Filling filling : bagel.getFillings()) {
                    totalCost += filling.getPrice();
                }
            }
            totalCost += product.getPrice();
        }
        return Math.round(totalCost * 100.0) / 100.0;
    }

}
