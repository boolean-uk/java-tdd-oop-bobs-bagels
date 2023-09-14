package com.booleanuk.core;

public abstract class Product extends Item implements Sellable{
    public Product(String sku, Double price, String name, String variant) {
        super(sku, price, name, variant);
    }
}
