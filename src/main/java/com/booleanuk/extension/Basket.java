package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Basket {
    private final List<Bagel> bagels;
    private final List<Coffee> coffees;
    private final Inventory inventory;
    private int capacity;

    public Basket(List<Bagel> bagels, List<Coffee> coffees, int capacity) {
        this.bagels = bagels;
        this.capacity = capacity;
        this.coffees = coffees;
        this.inventory = new Inventory();
    }

    public Basket(int capacity, Inventory inventory) {
        this.capacity = capacity;
        this.inventory = inventory;
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    private boolean canAddToCart() {
        return (bagels.size() + coffees.size()) < capacity;
    }

    public boolean add(Bagel bagel){
        if (!inventory.contains(bagel)) return false;

        if (!canAddToCart()) return false;

        bagels.add(bagel);
        return true;
    }

    public boolean add(Coffee coffee){
        if (!inventory.contains(coffee)) return false;

        if (!canAddToCart()) return false;

        coffees.add(coffee);
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

    public boolean remove(Coffee coffee){
        for(Coffee c : this.coffees){
            if(c.getVariant().equals(coffee.getVariant())){
                this.coffees.remove(c);
                return true;
            }
        }

        return false;
    }

    public boolean updateCapacity(int capacity){
        if(bagels.size() + coffees.size() >= capacity) return false;

        this.capacity = capacity;

        return true;
    }

    private <T> double sumOf(List<T> list, BiFunction<Double, T, Double> accumulator) {
        return list.stream().reduce(0.0, accumulator, Double::sum);
    }

    public double cost(){
        double bagelsCost = sumOf(bagels, (sum, b) -> sum += b.getPrice());
        double coffeesCost = sumOf(coffees, (sum, c) -> sum += c.getPrice());

        return bagelsCost + coffeesCost;
    }

    public double discountedCost() {

        return 0.0;
    }
}
