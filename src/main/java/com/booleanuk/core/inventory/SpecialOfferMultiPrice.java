package com.booleanuk.core.inventory;

public class SpecialOfferMultiPrice extends SpecialOffer{

    private String SKU;
    private int numOfItems;

    public SpecialOfferMultiPrice(String SKU, double offerPrice) {
        super(offerPrice);
        this.SKU = SKU;
    }

    public SpecialOfferMultiPrice(String SKU, int numOfItems, double offerPrice) {
        super(offerPrice);
        this.SKU = SKU;
        this.numOfItems = numOfItems;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
