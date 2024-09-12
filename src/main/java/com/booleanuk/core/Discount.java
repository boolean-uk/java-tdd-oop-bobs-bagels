package com.booleanuk.core;

public class Discount {
    private double cost;
    private int quantity;

    public Discount(double cost, int quantity) {
        this.cost = cost;
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getQuantity() + " " + getCost();
    }
}
