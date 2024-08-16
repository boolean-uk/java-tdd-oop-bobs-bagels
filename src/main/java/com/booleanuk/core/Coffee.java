package com.booleanuk.core;

public class Coffee extends Item{
    CoffeeType variant;

    public Coffee(double price, String SKA, String name, CoffeeType variant) {
        super(price, SKA, name);
        this.variant = variant;
    }
}
