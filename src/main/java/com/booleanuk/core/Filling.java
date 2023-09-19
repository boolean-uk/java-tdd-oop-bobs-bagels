package com.booleanuk.core;

public class Filling extends Foods{
    public Filling(String sku, double price, String variant) {
        super(sku, price, variant);
    }

    public Filling(String sku) {
        super(sku);
        setPrice();
        setVariant();
    }

    @Override
    public String toString(){
        return getVariant() + " " + getCost() + "$";
    }
}
