package com.booleanuk.core;

public class Bagel extends Product {

    Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    @Override
    public String showProduct() {
        return retrieveSku() + " " + retrievePrice() + " " + retrieveName() + " " + retrieveVariant();
    }


}
