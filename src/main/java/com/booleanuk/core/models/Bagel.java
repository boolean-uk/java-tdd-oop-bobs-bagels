package com.booleanuk.core.models;

import java.util.ArrayList;

public class Bagel extends Item{

    ArrayList<Filling> fillings;

    public Bagel(String SKU, double price, String variant) {
        super(SKU, price, variant);
    }
//Maybe we dont neeed this!!
    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<Filling> fillings) {
        this.fillings = fillings;
    }


    public double getFillingsPrice() {
        double totalPrice =0.0;
        for (Filling filling : fillings) {
            totalPrice+=filling.getPrice();
        }
        return totalPrice;
    }
}
