package com.booleanuk.core;

import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.interfaces.MenuCategory;

public abstract class Product {
    private String name;
    private Double price;
    private SKU sku;
    private MenuCategory variant;
    private Boolean isDiscounted;

    public Product(String name, Double price, SKU sku, MenuCategory variant) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
        this.isDiscounted = false;
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

    public Boolean getDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(Boolean discounted) {
        isDiscounted = discounted;
    }
}
