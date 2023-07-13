package com.booleanuk.core;

public class Product {
    private final String sku;
    private final float price;
    private final String name;
    private final String variant;
    private final int specialOfferQuantity;
    private final float specialOfferPrice;

    public Product(String sku, float price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.specialOfferQuantity = 0;
        this.specialOfferPrice = 0;
    }

    public Product(String sku, float price, String name, String variant, int specialOfferQuantity, float specialOfferPrice) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.specialOfferQuantity = specialOfferQuantity;
        this.specialOfferPrice = specialOfferPrice;
    }

    public float getPrice() {
        return price;
    }

    public int getSpecialOfferQuantity() {
        return specialOfferQuantity;
    }

    public float getSpecialOfferPrice() {
        return specialOfferPrice;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
