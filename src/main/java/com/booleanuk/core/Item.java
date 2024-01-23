package com.booleanuk.core;

public interface Item {
    String getSku();

    void setSku(String sku);

    String getName();

    String getVariant();

    void setVariant(String variant);

    double getPrice();

    void setPrice(double price);
}
