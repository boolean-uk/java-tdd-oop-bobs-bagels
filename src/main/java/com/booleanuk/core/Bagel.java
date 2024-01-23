package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel implements Item {
    private String sku;
    private final String name;
    private String variant;
    private double price;
    private ArrayList<Filling> fillings;

    public Bagel(String sku, String variant, double price) {
        this.setSku(sku);
        this.name = "Bagel";
        this.setVariant(variant);
        this.setPrice(price);
        this.fillings = new ArrayList<>();
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addFilling(Filling filling) {
        // Only possible to add 1 filling for each variant.
        if (!this.fillings.contains(filling)) {
            this.fillings.add(filling);
        }
    }

    public void removeFilling(Filling filling) {
        this.fillings.remove(filling);
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }
}
