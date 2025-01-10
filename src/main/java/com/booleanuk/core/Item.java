package com.booleanuk.core;

public class Item {
    private SKU sku;
    private float price;
    private ItemType type;
    private String variant;

    public Item(SKU sku, float price, ItemType type, String variant) {
        this.sku = sku;
        this.price = price;
        this.type = type;
        this.variant = variant;
    }
}
