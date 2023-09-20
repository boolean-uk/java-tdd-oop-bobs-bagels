package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Foods{
    ArrayList<Filling> fillingsList = new ArrayList<>();

    public Bagel(String sku, double price, String variant) {
        super(sku, price, variant);
    }

    public Bagel(String sku) {
        super(sku);
        setPrice();
        setVariant();
    }

    public void addFilling(Filling filling) {
        if (!this.fillingsList.contains(filling)) {
            this.fillingsList.add(filling);
        }
    }

    @Override
    public String toString(){
        String fillingsString = "";
        for (Filling filling: fillingsList) {
            fillingsString += "  " + filling.toString() + "\n";
        }
        return "bagel: \n  " + getVariant() + " " + getCost() + "$" + "\nFillings:\n" + fillingsString;
    }

    @Override
    public int getPrice() {
        int price = this.price;
        for (Filling filling : fillingsList) {
            price += filling.getPrice();
        }
        return price;
    }


}
