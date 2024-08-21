package com.booleanuk.core;

public class Filling extends Product {

    public Filling(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.FILLING;
    }
}
