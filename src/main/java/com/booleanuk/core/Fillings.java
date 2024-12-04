package com.booleanuk.core;

public class Fillings implements ItemInterface{
    private String type;
    private double price;
    private String sku;
    private String variant;

    public Fillings(String type, double price, String sku, String variant) {
        this.setType(type);
        this.setPrice(price);
        this.setSku(sku);
        this.setVariant(variant);
    }

    @Override
    public String toString() {
        return "Item: " + this.getVariant() + " " + this.getType() + "\n"
                + "Price: " + this.getPrice() + "\n"
                + "SKU: " + this.getSku();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
