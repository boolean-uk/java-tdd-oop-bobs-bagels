package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;

import java.util.ArrayList;
import java.text.DecimalFormat;

public abstract class Discount {

    private ArrayList<Product> productsInDiscount;
    private double priceBeforeDiscount = 0;
    private double priceAfterDiscount = 0;
    private double savedMoney = 0;

    public Discount(double newCost) {
        this.productsInDiscount = new ArrayList<>();
        this.priceAfterDiscount = newCost;
    }

    private void setSavedMoney() {
        this.savedMoney = this.priceBeforeDiscount - this.priceAfterDiscount;
        DecimalFormat df = new DecimalFormat("0.00");
        this.savedMoney = Double.parseDouble(df.format(this.savedMoney));
    }

    private void setPriceBeforeDiscount() {
        for (Product p : this.productsInDiscount) {
            this.priceBeforeDiscount += p.getPrice();
        }
    }

    public ArrayList<Product> getProductsInDiscount() {
        return this.productsInDiscount;
    }

    protected void setProductsInDiscount(ArrayList<Product> products) {
        this.productsInDiscount.addAll(products);
        this.setPriceBeforeDiscount();
        this.setSavedMoney();
    }

    public boolean checkIfApplies(ArrayList<Product> products) {
        return false;
    }

    public double getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public double getPriceAfterDiscount() {
        return this.priceAfterDiscount;
    }

    public double getSavedMoney() {
        return this.savedMoney;
    }

}
