package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private final ArrayList<Bagel> bagels;
    private final ArrayList<Coffee> coffees;
    private final Inventory inventory;
    private int capacity;

    public Basket(ArrayList<Bagel> bagels, ArrayList<Coffee> coffees, int capacity) {
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

    private double CoffeeBagelComboPrice() {
        return 1.25 * bagels.size();
    }

    public double discountedCost() {
        if (bagels.size() == coffees.size())
            return CoffeeBagelComboPrice();

        HashMap<String, ArrayList<Double>> bagelTypes = new HashMap<>();

        for (Bagel b : bagels) {
            ArrayList<Double> l = bagelTypes.getOrDefault(b.getVariant(), new ArrayList<>());
            l.add(b.getPrice());

            bagelTypes.put(b.getVariant(), l);
        }

        // 12 bagels offer
        if (12 bagels offer) {
            if (6 bagels offer) {
                if (rest are less than or equal to coffee)
            }
        } else if (6 bagels offer) {
            if (rest are less than or equal to coffee)
        } else if (rest are less than or equal to coffee) {

        }

        double sum = 0.0;

        for (ArrayList<Double> priceList : bagelTypes.values()) {
            sum += (priceList.size() / 6) * 2.49 + (priceList.size() % 6) * priceList.get(0);
        }

        return (int) (sum * 100) / 100.0; // keep only 2 decimals
    }
}
