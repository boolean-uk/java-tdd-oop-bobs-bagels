package com.booleanuk.core;

public class Coffee extends Product{


    public Coffee(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.COFFEE;
    }
}