package com.booleanuk.extension;

public class FillingExt {

    private SKU sku;
    private String name;
    private double price;


    public FillingExt(SKU sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
