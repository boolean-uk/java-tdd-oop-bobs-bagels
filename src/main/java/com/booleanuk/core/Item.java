package com.booleanuk.core;

public abstract class Item {
    private SKU sku;
    private float price;
    private String type;
    private String variant;

    public Item(SKU sku) {
        this.sku = sku;

        // Set price, type, and variant based on SKU
        if (sku == SKU.BGLO) {
            price = 0.49f;
            type = "Bagel";
            variant = "Onion";
        } else if (sku == SKU.BGLP) {
            price = 0.39f;
            type = "Bagel";
            variant = "Plain";
        } else if (sku == SKU.BGLE) {
            price = 0.49f;
            type = "Bagel";
            variant = "Everything";
        } else if (sku == SKU.BGLS) {
            price = 0.49f;
            type = "Bagel";
            variant = "Sesame";
        } else if (sku == SKU.COFB) {
            price = 0.99f;
            type = "Coffee";
            variant = "Black";
        } else if (sku == SKU.COFW) {
            price = 1.19f;
            type = "Coffee";
            variant = "White";
        } else if (sku == SKU.COFC) {
            price = 1.29f;
            type = "Coffee";
            variant = "Capuccino";
        } else if (sku == SKU.COFL) {
            price = 1.29f;
            type = "Coffee";
            variant = "Latte";
        } else if (sku == SKU.FILB) {
            price = 0.12f;
            type = "Filling";
            variant = "Bacon";
        } else if (sku == SKU.FILE) {
            price = 0.12f;
            type = "Filling";
            variant = "Egg";
        } else if (sku == SKU.FILC) {
            price = 0.12f;
            type = "Filling";
            variant = "Cheese";
        } else if (sku == SKU.FILX) {
            price = 0.12f;
            type = "Filling";
            variant = "Cream Cheese";
        } else if (sku == SKU.FILS) {
            price = 0.12f;
            type = "Filling";
            variant = "Smoked Salmon";
        } else if (sku == SKU.FILH) {
            price = 0.12f;
            type = "Filling";
            variant = "Ham";
        } else {
            throw new IllegalArgumentException("Invalid SKU: " + sku);
        }
    }

    SKU getSku() {
        return sku;
    }

    float getPrice() {
        return price;
    }

    String getType() {
        return type;
    }

    String getVariant() {
        return variant;
    }
}
