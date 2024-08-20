package com.booleanuk.core;

public abstract class Item {
    protected String sku;
    protected Integer price;
    protected String name;
    protected String variant;
    protected Integer quantity;

    public Item(String sku, Integer price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.quantity = 1;
    }

    public Integer getQuantity() { return this.quantity; }
    public Integer getPrice(){ return this.price; }
    public String getVariant(){ return ""; }
}
