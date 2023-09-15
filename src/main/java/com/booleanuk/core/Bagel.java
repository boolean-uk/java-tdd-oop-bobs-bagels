package com.booleanuk.core;

import java.math.BigDecimal;

public class Bagel extends Product implements Sellable, Fillable{
    public Bagel(String sku, BigDecimal price, String name, String variant) {
        super(sku, price, name, variant);
    }
    public Bagel(String sku) {
        super(sku);
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }

    // implement filling functionality
}
