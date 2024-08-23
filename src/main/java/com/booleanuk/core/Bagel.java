package com.booleanuk.core;

public class Bagel extends Product {
    Filling filling;

    Bagel(String sku, double price, String name, String variant, Filling filling) {
        super(sku, price, name, variant);
        this.filling = filling;
    }

    public Filling getFilling(){
        return this.filling;
    }

}
