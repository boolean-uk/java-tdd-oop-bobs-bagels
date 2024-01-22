package com.booleanuk.extension;

public class BulkDiscount implements Discount{
    private String sku;
    private int number;
    private double price;

    public BulkDiscount(String sku, int number, double price) {
        this.sku = sku;
        this.number = number;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }
    public int getNumber() {
        return number;
    }
    public double getPrice() {
        return price;
    }
}
