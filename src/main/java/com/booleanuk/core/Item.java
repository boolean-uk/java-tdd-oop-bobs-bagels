package com.booleanuk.core;

import java.util.ArrayList;

public class Item {

    private String skuCode;
    private String name;
    private double price;
    private String variant;
    public Item(String variant) {
        this.variant = variant;

    }

    public Item() {

    }


    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCodes) {
        this.skuCode = skuCodes;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
