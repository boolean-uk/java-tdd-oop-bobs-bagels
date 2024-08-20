package com.booleanuk.core;

import com.booleanuk.core.products.Product;

public abstract class Coffee extends Product {
    public Coffee(String SKU, double price) {
        super(SKU, price);
    }
}
