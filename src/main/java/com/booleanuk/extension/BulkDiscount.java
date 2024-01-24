package com.booleanuk.extension;

public class BulkDiscount extends Discount{
    private int number;

    public BulkDiscount(String sku, int number, double price) {
        super(sku, price);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
