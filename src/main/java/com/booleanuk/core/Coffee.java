package com.booleanuk.core;

public class Coffee extends Product{

    private CoffeeVariant coffeeVariant;

    public Coffee() {
    }

    public Coffee(String name, double price, String skw,CoffeeVariant coffeeVariant) {
        super(name, price, skw);
        this.coffeeVariant = coffeeVariant;
    }

    @Override
    public double getTotalCostOfProduct() {
        return getPrice();
    }
}
