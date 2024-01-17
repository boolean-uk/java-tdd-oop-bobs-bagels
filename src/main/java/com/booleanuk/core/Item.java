package com.booleanuk.core;

import java.util.ArrayList;

public class Item {

    private ArrayList<String> skuCodes;
    private String name;
    private double price;
    public Item() {

    }


    public ArrayList<String> getSkuCodes() {
        return skuCodes;
    }

    public void setSkuCodes(ArrayList<String> skuCodes) {
        this.skuCodes = skuCodes;
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
