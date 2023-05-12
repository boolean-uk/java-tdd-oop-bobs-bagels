package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Bagel> bagels;
    List<Coffee> coffees;
    Inventory inventory;
    int capacity;

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

    private boolean haveSameFillings(Bagel b, Bagel bagel) {
        for (Filling f : b.getFillings()) {
            for (Filling f2 : bagel.getFillings()) {
                if (!f.getVariant().equals(f2.getVariant()) || f.getPrice() != f2.getPrice()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean remove(Bagel bagel){
        for (Bagel b : this.bagels) {
            if (b.getVariant().equals(bagel.getVariant()) && b.getPrice() == bagel.getPrice()) {
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
        return true;
    }

    public boolean updateCapacity(int capacity){
        return true;
    }

    public double cost(){
        return 0.0;
    }

    public double costBagel(Bagel bagel){
        return 0.0;
    }

}
