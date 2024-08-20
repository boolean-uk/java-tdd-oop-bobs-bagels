package com.booleanuk.extension.extension;

import com.booleanuk.core.Item;

public class Coffee extends Item {
    private String coffeeType;

    public Coffee(String sku, double price, String name, String coffeeType) {
        super(sku, price, name);
        this.coffeeType = coffeeType;
    }

    public String getCoffeeType() {
        return coffeeType;
    }



}
