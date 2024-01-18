package com.booleanuk.core;

public class Product {




    protected String sku;
    protected String name;
    protected String variant;
    protected double price;


    public Product(String name, String variant, double price, String sku) {
        this.name = name;
        this.variant = variant;
        this.price = price;
        this.sku = sku.toUpperCase();
    }
    public Product(String variant, double price) {
        this.name = "Other";
        this.variant = variant;
        this.price = price;
        updateSku();
    }

    public Product(String name, String variant, double price) {
        this.name = name;
        this.variant = variant;
        this.price = price;
        updateSku();
    }

    private void updateSku() {
        this.sku = this.name.substring(0,2).toUpperCase() + this.variant.substring(0,1).toUpperCase();
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    public double getPrice() {
        return price;
    }

    public void setSku(String sku) {
        this.sku = sku.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
        updateSku();
    }

    public void setVariant(String variant) {
        this.variant = variant;
        updateSku();
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
