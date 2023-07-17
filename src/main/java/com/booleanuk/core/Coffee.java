package com.booleanuk.core;

public class Coffee extends Product{
    public Coffee(String sku, float price, String name, String variant) {
        super(sku, price, name, variant);
    }

    public Coffee(String sku, float price, String name, String variant, int specialOfferQuantity, float specialOfferPrice) {
        super(sku, price, name, variant, specialOfferQuantity, specialOfferPrice);
    }
}
