package com.booleanuk.core;

public class Filling extends Item{
    FillingType variant;

    public Filling(double price, String SKA, String name, FillingType variant) {
        super(price, SKA, name);
        this.variant = variant;
    }
}
