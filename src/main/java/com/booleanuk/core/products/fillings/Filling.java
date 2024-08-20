package com.booleanuk.core.products.fillings;

import com.booleanuk.core.products.Product;

public abstract class Filling extends Product {
    public Filling(String SKU, double price) {
        super(SKU, price);
    }
}
