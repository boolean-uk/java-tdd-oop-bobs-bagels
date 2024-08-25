package com.booleanuk.core.inventory;

import com.booleanuk.core.enums.ProductName;

import java.util.ArrayList;

public class SpecialOfferCombination  extends SpecialOffer{

    private ArrayList<ProductName> offerItems;          // List of items that in combination generates an offer

    public SpecialOfferCombination(double offerPrice) {
        super(offerPrice);
    }

    public SpecialOfferCombination(ArrayList<ProductName> offerItems, double offerPrice) {
        super(offerPrice);
        this.offerItems = offerItems;
    }

    public ArrayList<ProductName> getOfferItems() {
        return offerItems;
    }

    public void setOfferItems(ArrayList<ProductName> offerItems) {
        this.offerItems = offerItems;
    }
}
