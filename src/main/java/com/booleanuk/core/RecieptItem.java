package com.booleanuk.core;

public class RecieptItem extends Bagel{
    private int quantity;
    public RecieptItem(String sku, double price, String name, String variant, int quantity) {
        super(sku, price, variant, name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice(){
        return getPrice() * quantity;
    }
}
