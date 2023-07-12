package com.booleanuk.core.products;

public class Coffee extends Product {

    private CoffeeVariant variant;

    public Coffee(String SKU, double price) {
        super(SKU, price);
    }
}
