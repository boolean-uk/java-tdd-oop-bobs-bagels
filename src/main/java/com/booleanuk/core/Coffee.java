package com.booleanuk.core;

public class Coffee implements Product{
    private final Triple<String, String, Float> coffeeType;

    public Coffee(Triple<String, String, Float> coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public float calculateCost() {
        return coffeeType.c();
    }

    public Triple<String, String, Float> getCoffeeType() {
        return coffeeType;
    }

    @Override
    public String name() {
        return coffeeType.b();
    }

    @Override
    public float basicPrice() {
        return coffeeType.c();
    }
}
