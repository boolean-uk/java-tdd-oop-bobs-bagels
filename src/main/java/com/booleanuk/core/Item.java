package com.booleanuk.core;

public abstract class Item {

    protected String SKU = "";
    protected double price =0.0;

    public double getPrice() {
        return price;
    }
    public abstract boolean getAvailable();
}
