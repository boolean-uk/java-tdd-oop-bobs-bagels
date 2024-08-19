package com.booleanuk.core;

public abstract class Item {
    protected String sku;
    protected Double price;
    protected String name;
    protected String variant;
    protected Integer quantity;

    public Item(String sku, Double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.quantity = 1;
    }

    public Item(String sku, Double price, String name, String variant, Integer quantity) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.quantity = quantity;
    }

    public Integer getQuantity() { return this.quantity; }
    public Double getPrice(){ return 0.0; }
    public String getVariant(){ return ""; }
}
