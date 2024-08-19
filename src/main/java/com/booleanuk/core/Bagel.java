package com.booleanuk.core;

public class Bagel extends Product {
    Filling filling;

    public Bagel (String SKU, double price, String name, String variant){
        super(SKU, price, name, variant);
        filling = null;
    }

    @Override
    public String toString() {
        return super.toString()+
                " filling=" + filling +
                '}';
    }
}
