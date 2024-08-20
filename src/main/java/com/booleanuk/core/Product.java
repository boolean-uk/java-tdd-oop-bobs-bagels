package com.booleanuk.core;

import com.booleanuk.core.enums.SKU;

public abstract class Product {
    private String name;
    private Double price;
    private SKU sku;

    public Product(String name, Double price, SKU sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public Double getPrice() {
        return this.price;
    }
}
