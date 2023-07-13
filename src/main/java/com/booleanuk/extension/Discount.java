package com.booleanuk.extension;

public class Discount {
    private final int discountPackSize;
    private final double packPriceAfterDiscount;

    public Discount(int discountPackSize, double packPriceAfterDiscount) {
        this.discountPackSize = discountPackSize;
        this.packPriceAfterDiscount = packPriceAfterDiscount;
    }

    public int getDiscountPackSize() {
        return discountPackSize;
    }

    public double getPackPriceAfterDiscount() {
        return packPriceAfterDiscount;
    }
}
