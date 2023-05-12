package com.booleanuk.core.models;

import java.util.ArrayList;

public class BasketItem {
    String variant;
    double price;
    String SKU;

    public BasketItem(String variant, double price, String SKU) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }
}
