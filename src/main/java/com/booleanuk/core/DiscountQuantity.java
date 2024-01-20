package com.booleanuk.core;

import java.util.ArrayList;

public class DiscountQuantity {
    private String sku;
    private int quantity;
    private double price;
    public DiscountQuantity(String sku, int quantity, double price){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return getQuantity() + " " + getPrice();
    }
}
