package com.booleanuk.core;

public class Coffee extends Item{
    CoffeeType variant;

    public Coffee(String SKA, String name, CoffeeType variant) {
        super(SKA, name);
        this.variant = variant;
    }
}
