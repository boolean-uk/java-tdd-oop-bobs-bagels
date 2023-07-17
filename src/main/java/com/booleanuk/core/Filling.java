package com.booleanuk.core;

public class Filling extends Product{


    private FillingVariant fillingVariant;

    public Filling() {
    }

    public Filling(String name, double price, String skw,FillingVariant fillingVariant) {
        super(name, price, skw);
        this.fillingVariant = fillingVariant;
    }

    @Override
    public double getTotalCostOfProduct() {
        return getPrice();
    }
}
