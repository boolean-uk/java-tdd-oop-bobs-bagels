package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Basket {
    private List<Bagel> bagels;
    private List<Coffee> coffees;
    private Inventory inventory;
    private int capacity;

    public Basket(List<Bagel> bagels,List<Coffee> coffees, int capacity) {
        this.bagels = bagels;
        this.capacity = capacity;
        this.coffees = coffees;
        this.inventory = new Inventory();
    }

    public Basket(int capacity) {
        this.capacity = capacity;
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
        this.inventory = new Inventory();
    }

    public boolean add(Bagel bagel){
        if (!inventory.contains(bagel)) return false;

        bagels.add(bagel);
        return true;
    }

    public boolean remove(Bagel bagel){
        for (Bagel b : this.bagels) {
            if (b.getVariant().equals(bagel.getVariant()) && b.getFillings().containsAll(bagel.getFillings())) {
                this.bagels.remove(b);
                return true;
            }
        }

        return false;
    }



    public boolean add(Coffee coffee){
        if (!inventory.contains(coffee)) return false;

        coffees.add(coffee);
        return true;
    }

    public boolean remove(Coffee coffee){
        for( Coffee c : this.coffees){
            if(c.getVariant().equals(coffee.getVariant())){
                this.coffees.remove(c);
                return true;
            }

        }
        return false;



    }

    public boolean updateCapacity(int capacity){
        if(bagels.size() > capacity){
            return false;
        } else {
           this.capacity = capacity;
           return true;
        }
    }

    public double cost(){
        double totalPrice = 0.0;
        for (Bagel b : bagels){
            totalPrice += b.getPrice();
        }
        return totalPrice;
    }

    public double costBagel(Bagel bagel){
        return bagel.getPrice();
    }

}
