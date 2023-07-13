package com.booleanuk.extension;

public class Discount {
    private final int discountPackSize;
    private final int packPriceAfterDiscount;

    public Discount(int discountPackSize, int packPriceAfterDiscount) {
        this.discountPackSize = discountPackSize;
        this.packPriceAfterDiscount = packPriceAfterDiscount;
    }

    public int getDiscountPackSize() {
        return discountPackSize;
    }

    public int getPackPriceAfterDiscount() {
        return packPriceAfterDiscount;
    }
}
