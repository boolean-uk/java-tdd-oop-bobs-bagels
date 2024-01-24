package com.booleanuk.core;


import java.util.ArrayList;
import java.util.List;
// Class representing a generic product
class Product implements BasketItem, StockItem {
    private String sku;
    private double price;
    private String name;
    private String variant;

    public Product(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public int getCost() {
        // In this example, we return a rounded int value, but in a real scenario,
        // you might want to handle the price as a double for more accuracy.
        return (int) Math.round(price * 100);
    }

    public boolean isInStock() {
        // Placeholder logic, you might want to implement this based on your business rules
        return true;
    }
}