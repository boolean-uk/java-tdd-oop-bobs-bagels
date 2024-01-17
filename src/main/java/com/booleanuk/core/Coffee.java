package com.booleanuk.core;

public class Coffee extends Item {
    public Coffee(String variant) {
        super(variant);
        this.setName("Coffee");
        this.setPrice(0.99);
    }
}
