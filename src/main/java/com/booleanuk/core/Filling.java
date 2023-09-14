package com.booleanuk.core;

public class Filling extends Item {
    public Filling(String sku, Double price, String name, String variant) {
        super(sku, price, name, variant);
    }
// double filling etc.
    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }
}
