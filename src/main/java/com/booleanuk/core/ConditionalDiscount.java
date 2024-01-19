package com.booleanuk.core;

public class ConditionalDiscount extends Discount {
    public final Category[] hasItems;
    public final double newPrice;

    public ConditionalDiscount(Category[] conditionalItems, double newPrice) {
        hasItems = conditionalItems;
        this.newPrice = newPrice;
    }

    @Override
    public double applyDiscount(Order order) {
        return 0.0;
    }
}
