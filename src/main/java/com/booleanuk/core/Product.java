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

        return (int) Math.round(price * 100);
    }

    public boolean isInStock() {
        return true;
    }
}