package com.booleanuk.core.models;

import com.booleanuk.core.Invetory;

import java.util.ArrayList;

public class Bagel extends Item {


    ArrayList<Filling> fillings;

    public Bagel(String variant, double price, String SKU) {
        super(variant, price, SKU);
        this.fillings=new ArrayList<>();
    }

    //Maybe we dont neeed this!!
    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    public boolean setFillings(ArrayList<Filling> fillings, Invetory invetory) {
        for (Filling filling : fillings) {
            for (Filling invFilling : invetory.getFillings()) {
                if (invFilling.getSKU().equals(filling.getSKU())) {
                    this.fillings = fillings;
                    return true;
                }
            }
        }
        return false;
    }

    public void setFillings(Filling filling) {
        fillings.add(filling);
    }

    public double getFillingsPrice() {
        double totalPrice = 0.0;
        for (Filling filling : fillings) {
            totalPrice += filling.getPrice();
        }
        return totalPrice;
    }
}
