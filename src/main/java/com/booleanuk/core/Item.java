package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Item {
    protected String sku;
    protected Double price;
    protected String name;
    protected String variant;

    public Item(String sku, Double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public Double getPrice(){return 0.0;}
    public String getVariant(){return "";}
}
