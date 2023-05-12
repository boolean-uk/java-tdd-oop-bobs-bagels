package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Bagel> bagels;
    List<Coffee> coffees;
    int capacity;

    public Basket(List<Bagel> bagels,List<Coffee> coffees, int capacity ){
        this.bagels = bagels;
        this.capacity = capacity;
        this.coffees = coffees;
    }

    public Basket(int capacity){
        this.capacity = capacity;
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    public boolean add(Bagel bagel){
        return true;
    }

    public boolean remove(Bagel bagel){
        return true;
    }

    public boolean add(Coffee coffee){
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
