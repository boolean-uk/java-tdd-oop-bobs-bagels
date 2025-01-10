package com.booleanuk.core;

public class Item {
    private SKU sku;
    private float price;
    private String type;
    private String variant;

    public Item(SKU sku) {
        this.sku = sku;

        // set price, type and variant based on sku
        if (sku == SKU.BGLO) {
            price = 0.49f;
            type = "Bagel";
            variant = "Onion";
        } 
    }
}
