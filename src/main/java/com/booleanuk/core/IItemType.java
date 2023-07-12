package com.booleanuk.core;

public interface IItemType {
    public double price = 0;
    public String variant = "";
    public String sku = "";
    public default double getPrice() {
        return price;
    }
    public default String getVariant() {
        return variant;
    }
    public default String getSku() {
        return sku;
    }
}
