package com.booleanuk.core;

public class Bagel extends Inventory{

    private String name;
    private String variant;
    private String sku;
    private double price;

    public Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        if (variant.equals("Onion")) {
            this.sku = "BGLO";
            this.name = "Bagel";
            this.price = 0.49;
        }
        else if (variant.equals("Plain")) {
            this.sku = "BGLP";
            this.name = "Bagel";
            this.price = 0.39;
        }
        else if (variant.equals("Everything")) {
            this.sku = "BGLE";
            this.name = "Bagel";
            this.price = 0.49;
        }
        else if (variant.equals("Sesame")) {
            this.sku = "BGLS";
            this.name = "Bagel";
            this.price = 0.49;
        }
    }

    @Override
    public String toString() {
        return variant;
    }
}
