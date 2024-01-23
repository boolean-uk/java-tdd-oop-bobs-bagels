package com.booleanuk.core;

public class Coffee extends Item {
    public Coffee(String coffeeType, double price, String sku) {
        super("Coffee", price, sku, coffeeType);
    }
}
