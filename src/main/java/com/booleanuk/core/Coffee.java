package com.booleanuk.core;

public class Coffee extends Item{
    CoffeeType variant;

    public Coffee(CoffeeType variant) {
        //super(SKA, name);
        super();
        this.variant = variant;
    }
}
