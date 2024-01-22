package com.booleanuk.core;

public class NumberOfItemsDiscount extends Discount {
    private final int itemCount;
    private final double discountPrice;

    public NumberOfItemsDiscount(int itemCount, double discountPrice) {
        this.itemCount = itemCount;
        this.discountPrice = discountPrice;
    }

    @Override
    public double applyDiscount(Order order, final Order[] orders) {
        return itemCount <= order.amount ? ShoppingManager.getPriceCount(order.itemUUID, itemCount) - discountPrice : 0.0;
    }
}
