package com.booleanuk.core;

import com.booleanuk.core.products.Product;

public abstract class Filling extends Product {
    public Filling(String SKU, double price) {
        super(SKU, price);
    }
}
