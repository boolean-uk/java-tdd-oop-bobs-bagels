package com.booleanuk.core;

public class Filling extends Product {
    String name;
    Filling(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        this.name = name;
    }
}
