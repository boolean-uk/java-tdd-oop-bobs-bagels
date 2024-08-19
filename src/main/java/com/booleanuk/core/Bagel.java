package com.booleanuk.core;

public class Bagel extends Product {

    private Filling[] fillings;

    public Bagel(String sku, int price, String variant) {
        super(sku, price, variant);
        this.fillings = new Filling[2];
    }

}
