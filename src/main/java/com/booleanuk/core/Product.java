package com.booleanuk.core;

import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.interfaces.MenuCategory;

public abstract class Product {
    private String name;
    private Double price;
    private SKU sku;
    private MenuCategory variant;
    private Boolean hasDiscount;
    private int quantity;

    public Product(String name, Double price, SKU sku, MenuCategory variant) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
        this.hasDiscount = false;
        this.quantity = 1;
    }

    public Product() {}

    public Double getPrice() {
        return this.price;
    }

    public MenuCategory getVariant() {
        return variant;
    }

    public String getName() {
        return name;
    }

    public SKU getSku() {
        return sku;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Boolean discounted) {
        hasDiscount = discounted;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
