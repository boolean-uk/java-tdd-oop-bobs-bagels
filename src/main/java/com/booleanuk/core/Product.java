package com.booleanuk.core;

public interface Product {
    String getSKU();
    String getName();
    String getType();
    double getPrice();
    boolean hasDiscount();
    default boolean equals(Product otherProduct){
        return otherProduct.getSKU().equals(getSKU());
    }

    default boolean equals(String SKU){
        return SKU.equals(this.getSKU());
    }
}
