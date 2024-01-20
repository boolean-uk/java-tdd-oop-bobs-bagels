package com.booleanuk.core;

import java.util.Arrays;

public class DiscountCombo {
    private String[] sku;
    private double price;
    public DiscountCombo(String[] sku, double price){
        this.sku = sku;
        this.price = price;
    }

    public String[] getSku() {
        return sku;
    }

    public void setSku(String[] sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return Arrays.toString(getSku()) + " " + getPrice();
    }
}
