package com.booleanuk.core;

public class Bagel extends Product implements Sellable{
    public Bagel(String sku, Double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }
}
