package com.booleanuk.core;

public class Item {
    private SKU sku;
    private float price;
    private ItemType type;
    private String variant;

    public Item(SKU sku) {
        this.sku = sku;
    }
}
