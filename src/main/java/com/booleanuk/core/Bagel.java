package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel {
    private final String variant;
    private final double price;
    private final List<Filling> fillings;

    private Inventory inventory;

    public Bagel(String variant, double price, List<Filling> fillings, Inventory inventory){
        this.variant = variant;
        this.price = price;
        this.fillings = fillings;
        this.inventory = inventory;
    }

    public Bagel(String variant, double price, Inventory inventory){
        this.variant = variant;
        this.price = price;
        this.fillings = new ArrayList<>();
        this.inventory = inventory;
    }

    public String getVariant(){
        return this.variant;
    }

    public double getPrice() {
        return this.price +
                this.fillings.stream().reduce(0.0, (sum, f) -> sum += f.getPrice(), Double::sum);
    }

    public boolean addFilling(Filling filling) {
        if (!inventory.contains(filling)){
            return false;
        }
        this.fillings.add(filling);

        return true;
    }

    public List<Filling> getFillings() {
        return this.fillings;
    }
}