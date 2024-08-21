package com.booleanuk.core;

public class Bagel extends Product{


    public Bagel(float price, Enum variant) {
        super(price, variant);
    }

    @Override
    public ProductName setName() {
        return ProductName.BAGEL;
    }
}
