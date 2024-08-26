package com.booleanuk.core.calculators;

public class DiscountObjectMultiPrice {

    private String SKU;
    private int numberOfDiscounts;
    private int numOfDiscountItems;         // Number of items that is counted into the discount. E.g.	6 for 2.49
    private double discountSum;
    private int numOfOrdinaryItems;         // Items without discountSum

    public DiscountObjectMultiPrice(String SKU, int numberOfDiscounts, int numOfDiscountItems, double discountSum, int numOfOrdinaryItems) {
        this.SKU = SKU;
        this.numberOfDiscounts = numberOfDiscounts;
        this.numOfDiscountItems = numOfDiscountItems;
        this.discountSum = discountSum;
        this.numOfOrdinaryItems = numOfOrdinaryItems;
    }

    public String getSKU() {
        return SKU;
    }

//    public void setSKU(String SKU) {
//        this.SKU = SKU;
//    }

    public int getNumberOfDiscounts() {
        return numberOfDiscounts;
    }

//    public void setNumberOfDiscounts(int numberOfDiscounts) {
//        this.numberOfDiscounts = numberOfDiscounts;
//    }

    public int getNumOfDiscountItems() {
        return numOfDiscountItems;
    }

//    public void setNumOfDiscountItems(int numOfDiscountItems) {
//        this.numOfDiscountItems = numOfDiscountItems;
//    }

    public double getDiscount() {
        return discountSum;
    }

//    public void setDiscount(double discountSum) {
//        this.discountSum = discountSum;
//    }

    public int getNumOfOrdinaryItems() {
        return numOfOrdinaryItems;
    }

//    public void setNumOfOrdinaryItems(int numOfOrdinaryItems) {
//        this.numOfOrdinaryItems = numOfOrdinaryItems;
//    }
}
