package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Product {

    String SKU;
    double price;
    String variant;

    public Product(String SKU, double price, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }
}
