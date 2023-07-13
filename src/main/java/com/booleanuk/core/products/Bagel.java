package com.booleanuk.core.products;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {

    private List<Filling> fillings = new ArrayList<>();
    private BagelVariant variant;

    public Bagel(String SKU, double price) {
        super(SKU, price);
    }

    public double getPriceWithFilling() {
        return 0;
    }

    @Override
    public double getPrice() {
        double fillingsprice=0;
        for (Filling filling:fillings
             ) {
            fillingsprice+=filling.getPrice();
        }
        return super.getPrice()+fillingsprice;
    }

    public BagelVariant getVariant() {
        return variant;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void addFilling(Filling filling){ fillings.add(filling);}


    @Override
    public String toString() {
        return  super.toString() +
                "Bagel"+
                ", variant=" + variant +
                '}';
    }
}
