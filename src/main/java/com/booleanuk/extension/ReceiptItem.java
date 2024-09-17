package com.booleanuk.extension;

public class ReceiptItem {

    private Product product;
    private int quantity;
    private double cost;
    private double specialOfferCost;

    public ReceiptItem(Product product, int quantity, double cost, double specialOfferCost) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.specialOfferCost = specialOfferCost;
    }

    public String getProductName() {
        return this.product.getName();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getCost() {
        return this.cost;
    }

    public double getSpecialOfferCost() {
        return this.specialOfferCost;
    }
}
