package com.booleanuk.core.inventory;

public abstract class SpecialOffer {

    private String SKU;
    private double offerPrice;

    public SpecialOffer(String SKU, double offerPrice) {
        this.offerPrice = offerPrice;
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }
}
