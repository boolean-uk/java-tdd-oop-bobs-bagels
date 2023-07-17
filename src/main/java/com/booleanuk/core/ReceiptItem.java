package com.booleanuk.core;

public class ReceiptItem extends Bagel {
    private int quantity;

    public ReceiptItem(String sku, double price, String name, String variant, int quantity) {
        super(sku, price, name, variant);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return getPrice() * quantity;
    }
}