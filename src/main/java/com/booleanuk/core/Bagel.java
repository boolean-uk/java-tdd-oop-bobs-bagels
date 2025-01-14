package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    private ArrayList<Filling> fillings = new ArrayList<>();
    private int maxFillings = 3;

    public Bagel(String id, double price, String description) {
        super(id, price, description);
    }

    // Allows up to only 3 fillings (let's not get silly here) to be attached to bagels
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
