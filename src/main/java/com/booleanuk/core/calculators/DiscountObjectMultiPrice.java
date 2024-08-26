package com.booleanuk.core.calculators;

public class DiscountObjectMultiPrice {

    // TODO: Confusing to use this object for both items with discounts and items without discounts for a specific SKU

    private String SKU;

    private int numberOfDiscounts;
    private int numOfDiscountItems;         // Number of items that is counted into the discount. E.g.	6 for 2.49
    private double priceForDiscountItems;
    private double discount;

    private int numOfOrdinaryItems;         // Items without discountSum
    private double priceForOrdinaryItems;

    public DiscountObjectMultiPrice(
            String SKU, int numberOfDiscounts,
            int numOfDiscountItems,
            double priceForDiscountItems,
            double discount,
            int numOfOrdinaryItems,
            double priceForOrdinaryItems)
    {
        this.SKU = SKU;
        this.numberOfDiscounts = numberOfDiscounts;
        this.numOfDiscountItems = numOfDiscountItems;
        this.priceForDiscountItems = priceForDiscountItems;
        this.discount = discount;
        this.numOfOrdinaryItems = numOfOrdinaryItems;
        this.priceForOrdinaryItems = priceForOrdinaryItems;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getNumberOfDiscounts() {
        return numberOfDiscounts;
    }

    public void setNumberOfDiscounts(int numberOfDiscounts) {
        this.numberOfDiscounts = numberOfDiscounts;
    }

    public int getNumOfDiscountItems() {
        return numOfDiscountItems;
    }

    public void setNumOfDiscountItems(int numOfDiscountItems) {
        this.numOfDiscountItems = numOfDiscountItems;
    }

    public double getPriceForDiscountItems() {
        return priceForDiscountItems;
    }

    public void setPriceForDiscountItems(double priceForDiscountItems) {
        this.priceForDiscountItems = priceForDiscountItems;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNumOfOrdinaryItems() {
        return numOfOrdinaryItems;
    }

    public void setNumOfOrdinaryItems(int numOfOrdinaryItems) {
        this.numOfOrdinaryItems = numOfOrdinaryItems;
    }

    public double getPriceForOrdinaryItems() {
        return priceForOrdinaryItems;
    }

    public void setPriceForOrdinaryItems(double priceForOrdinaryItems) {
        this.priceForOrdinaryItems = priceForOrdinaryItems;
    }
}
