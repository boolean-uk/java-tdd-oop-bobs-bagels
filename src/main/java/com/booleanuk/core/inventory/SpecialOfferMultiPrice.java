package com.booleanuk.core.inventory;

public class SpecialOfferMultiPrice extends SpecialOffer{

    private int numOfItems;

    public SpecialOfferMultiPrice(String SKU, double offerPrice) {
        super(SKU, offerPrice);
    }

    public SpecialOfferMultiPrice(String SKU, int numOfItems, double offerPrice) {
        super(SKU, offerPrice);
        this.numOfItems = numOfItems;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
