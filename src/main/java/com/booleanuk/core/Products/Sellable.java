package com.booleanuk.core.Products;

public interface Sellable {
    public abstract double calculateTotalPrice(int quantity);
    // Either abstract method in Item or in Sellable interface
}
