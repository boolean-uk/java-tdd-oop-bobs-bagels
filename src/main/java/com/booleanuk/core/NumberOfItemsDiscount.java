package com.booleanuk.core;

public class NumberOfItemsDiscount extends Discount {
    private final Category ofCategory;
    private final int itemCount;
    private final double discountPrice;

    public NumberOfItemsDiscount(Category ofCategory, int itemCount, double discountPrice) {
        this.ofCategory = ofCategory;
        this.itemCount = itemCount;
        this.discountPrice = discountPrice;
    }

    @Override
    public double applyDiscount(Order order) {
        return 0.0;
    }
}
