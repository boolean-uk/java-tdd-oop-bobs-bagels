package com.booleanuk.core;

public class Item {
    public final double price;
    public final String uuid;
    public final String variant;
    public final Category category;

    public Item(double price, String variant, String uuid, Category category) {
        this.price = price;
        this.uuid = uuid;
        this.variant = variant;
        this.category = category;
    }
}
