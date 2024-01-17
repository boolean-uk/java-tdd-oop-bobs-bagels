package com.booleanuk.core;

public class Bagel extends Item {
    private String variant;

    public Bagel(String variant, double price) {
        super("Bagel", price);
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
