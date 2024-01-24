package com.booleanuk.core;

class SpecialOffer {
    private int quantity;
    private double offerPrice;

    public SpecialOffer(int quantity, double offerPrice) {
        this.quantity = quantity;
        this.offerPrice = offerPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getOfferPrice(int quantity) {
        if (quantity==6){
            return 2.49;
        }
        if (quantity==12){
            return 3.99;
        }
        return offerPrice;
    }
}
