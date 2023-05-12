package com.booleanuk.core.order;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Bagel> bagels;
    List<Coffee> coffees;
    int capacity;

    public Basket(int capacity){
        this.capacity = capacity;
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    public Basket(List<Bagel> bagels, List<Coffee> coffees, int capacity) {
        this.bagels = bagels;
        this.capacity = capacity;
        this.coffees = coffees;
    }

    private boolean canAddTo(List<?> aList) {
        return aList.size() < this.capacity;
    }

    public boolean add(Bagel bagel){
        if (!canAddTo(this.bagels)) return false;

        this.bagels.add(bagel);
        return true;
    }

    public boolean remove(Bagel bagel){
        return true;
    }

    public boolean add(Coffee coffee){
        if (!canAddTo(this.coffees)) return false;

        this.coffees.add(coffee);
        return true;
    }

    public boolean remove(Coffee coffee){
        return true;
    }

    public boolean updateCapacity(int capacity){
        return true;
    }

    public double cost(){
        return this.coffees.stream().reduce(0.0, (sum, c) -> sum += c.getPrice(), Double::sum) +
                this.bagels.stream().reduce(0.0, (sum, c) -> sum += c.getPrice(), Double::sum);
    }
}
