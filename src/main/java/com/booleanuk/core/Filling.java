package com.booleanuk.core;

public class Filling extends Product{
    public Filling(String sku, float price, String name, String variant) {
        super(sku, price, name, variant);
    }

    public Filling(String sku, float price, String name, String variant, int specialOfferQuantity, float specialOfferPrice) {
        super(sku, price, name, variant, specialOfferQuantity, specialOfferPrice);
    }
}
