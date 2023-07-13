package com.booleanuk.core;

public class Filling extends Product {
    public Filling(String SKU, Double price, String variant) {
        super(SKU, price, variant);
    }

    @Override
    public String toString() {
        return variant + " (" + price + "£)";
    }

    @Override
    public Filling clone() {
        return new Filling(SKU, price, variant);
    }
}
