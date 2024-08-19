package com.booleanuk.core;

public class Order {
    private int totalSum;

    public Order() {
        this.totalSum = 0;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void addProduct(Product product) {
        totalSum += product.getPrice();
    }
}
