package com.booleanuk.core;

public class Product {
    private int price;
    private final String variant;
    private final String SKU;

    Product(String SKU, double price, String variant) {
        setPrice(price);
        this.variant = variant;
        this.SKU = SKU;
    }

    public double getPrice() {
        return price / 100.0; // convert to double
    }

    private void setPrice(double price) {
        this.price = (int) (price * 100); // number of cents as an int
    }

    public String getVariant() {
        return variant;
    }


    public String getSKU() {
        return SKU;
    }

}
