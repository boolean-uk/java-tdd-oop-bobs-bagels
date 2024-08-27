package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{

    private final List<Filling> fillings;

    public Bagel(String name, double price, String sku){
        super(name, price, sku);
        this.fillings = new ArrayList<>();
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    @Override
    public double getPrice() {

        double totalPrice = super.getPrice();

        for (Filling filling : fillings) {

            totalPrice += filling.getPrice();

        }
        return totalPrice;
    }

}

