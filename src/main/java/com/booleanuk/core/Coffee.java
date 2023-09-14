package com.booleanuk.core;

public class Coffee extends Product implements Sellable{
    public Coffee(String sku, Double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }
}
