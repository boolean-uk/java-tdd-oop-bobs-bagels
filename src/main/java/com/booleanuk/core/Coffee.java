package com.booleanuk.core;

public class Coffee extends Product{

    Coffee(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    @Override
    public String showProduct() {
        return getSku() + " " + getPrice() + " " + getName() + " " + getVariant();
    }

}
