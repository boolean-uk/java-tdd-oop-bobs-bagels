package com.booleanuk.core;

public class Coffee extends Item {
    private String coffeeType;

    public Coffee(String coffeeType) {
        super("Coffee", 0.0); // Coffee price is managed by the Item class
        this.coffeeType = coffeeType;
    }

    public String getCoffeeType() {
        return coffeeType;
    }
}
