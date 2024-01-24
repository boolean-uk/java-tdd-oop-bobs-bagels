package com.booleanuk.core;

public class Filling extends Product{

    public Filling(String name, String sku) {
        super(name, sku, 0.12);
    }

    public Filling(String name, String sku, double price) {
        super(name, sku, price);
    }

}
