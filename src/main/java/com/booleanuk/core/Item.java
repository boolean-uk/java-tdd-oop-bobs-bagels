package com.booleanuk.core;

public class Item {
    private String sku;
    private String name;
    private String variant;
    private float price;

    public Item(String sku) {
        this.sku = sku;

        if (sku.equals("BGLO")) {
            this.name = "Bagel";
            this.variant = "Onion";
            this.price = 0.49f;
        } else if (sku.equals("BGLP")) {
            this.name = "Bagel";
            this.variant = "Plain";
            this.price = 0.39f;
        } else if (sku.equals("BGLE")) {
            this.name = "Bagel";
            this.variant = "Everything";
            this.price = 0.49f;
        } else if (sku.equals("BGLS")) {
            this.name = "Bagel";
            this.variant = "Sesame";
            this.price = 0.49f;
        } else if (sku.equals("COFB")) {
            this.name = "Coffee";
            this.variant = "Black";
            this.price = 0.99f;
        } else if (sku.equals("COFW")) {
            this.name = "Coffee";
            this.variant = "White";
            this.price = 1.19f;
        } else if (sku.equals("COFC")) {
            this.name = "Coffee";
            this.variant = "Capuccino";
            this.price = 1.29f;
        } else if (sku.equals("COFL")) {
            this.name = "Coffee";
            this.variant = "Latte";
            this.price = 1.29f;
        } else if (sku.equals("FILB")) {
            this.name = "Filling";
            this.variant = "Bacon";
            this.price = 0.12f;
        } else if (sku.equals("FILE")) {
            this.name = "Filling";
            this.variant = "Egg";
            this.price = 0.12f;
        } else if (sku.equals("FILC")) {
            this.name = "Filling";
            this.variant = "Cheese";
            this.price = 0.12f;
        } else if (sku.equals("FILX")) {
            this.name = "Filling";
            this.variant = "Cream Cheese";
            this.price = 0.12f;
        } else if (sku.equals("FILS")) {
            this.name = "Filling";
            this.variant = "Smoked Salmon";
            this.price = 0.12f;
        } else if (sku.equals("FILH")) {
            this.name = "Filling";
            this.variant = "Ham";
            this.price = 0.12f;
        } else {
            throw new IllegalArgumentException("Invalid SKU: " + sku);
        }
    }


    public String getSku() {return sku;}

    public String getName() {return name;}

    public String getVariant() {return variant;}

    public float getPrice() {return price;}
}
