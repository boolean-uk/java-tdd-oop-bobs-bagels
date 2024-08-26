package com.booleanuk.core.calculators;

import com.booleanuk.core.enums.ProductName;

import java.util.ArrayList;

public class DiscountObjectCombination {

    private ArrayList<ProductName> offerItems;
    private int numOfDiscounts;
    private double discountSum;

    public DiscountObjectCombination(ArrayList<ProductName> offerItems, int numOfDiscounts, double discountSum) {
        this.offerItems = offerItems;
        this.numOfDiscounts = numOfDiscounts;
        this.discountSum = discountSum;
    }

    public ArrayList<ProductName> getOfferItems() {
        return offerItems;
    }

    public void setOfferItems(ArrayList<ProductName> offerItems) {
        this.offerItems = offerItems;
    }

    public int getNumOfDiscounts() {
        return numOfDiscounts;
    }

    public void setNumOfDiscounts(int numOfDiscounts) {
        this.numOfDiscounts = numOfDiscounts;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(double discountSum) {
        this.discountSum = discountSum;
    }
}
