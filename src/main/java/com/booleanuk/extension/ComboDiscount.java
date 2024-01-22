package com.booleanuk.extension;

public class ComboDiscount implements Discount{
    private String sku;
    private String name;
    private double price;

    public ComboDiscount(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return price;
    }
}