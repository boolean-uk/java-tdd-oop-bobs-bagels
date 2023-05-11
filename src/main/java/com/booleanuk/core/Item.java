package com.booleanuk.core;

public class Item {
    String type;
    double price;
    String sku;
    String variant;

    public Item(String type, double price, String sku, String variant) {
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "Item: " + this.variant + " " + this.type + "\n"
                + "Price: " + this.price + "\n"
                + "SKU: " + this.sku;
    }

}
