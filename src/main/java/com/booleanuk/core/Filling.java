package com.booleanuk.core;

public class Filling extends Item{
    FillingType variant;

    public Filling(String SKA, String name, FillingType variant) {
        super(SKA, name);
        this.variant = variant;
    }
}
