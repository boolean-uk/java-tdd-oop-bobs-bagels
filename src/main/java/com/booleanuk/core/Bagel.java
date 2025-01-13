package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    private ArrayList<Filling> fillings = new ArrayList<>();
    private int maxFillings = 3;

    public Bagel(String id, double price, String description) {
        super(id, price, description);
    }

    // Allows fillings to be attached to bagels. Number of items in basket should be decreased by 1 if this is done
    // Logic for making that happen is in the Basket class
    public boolean attachFilling(Filling filling) {
        System.out.println(this.fillings.size());
        if (this.fillings.size() <= this.maxFillings - 1) {
            this.fillings.add(filling);
            return true;
        }
        return false;
    }

    public ArrayList<Filling> getAllFillings() {
        return this.fillings;
    }
}
