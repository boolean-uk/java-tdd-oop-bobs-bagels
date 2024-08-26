package com.booleanuk.core.inventory;

public abstract class SpecialOffer {

    private double offerPrice;

    public SpecialOffer(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }
}
