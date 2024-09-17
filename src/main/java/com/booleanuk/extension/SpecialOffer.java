package com.booleanuk.extension;

public class SpecialOffer {
    private String SKU;
    private int quantity;
    private double offerPrice;

    public SpecialOffer(String SKU, int quantity, double offerPrice) {
        this.SKU = SKU;
        this.quantity = quantity;
        this.offerPrice = offerPrice;
    }

    public String getSKU() {
        return SKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getOfferPrice() {
        return offerPrice;
    }
}
