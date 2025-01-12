package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    private ArrayList<Filling> fillings;

    public Bagel(String id, double price, String description) {
        super(id, price, description);
    }

    // Allows fillings to be attached to bagels. Number of items in basket should be decreased by 1 if this is done
    // Logic for making that happen is in the Basket class
    public void attachFilling(Filling filling) {

    }

    public ArrayList<Filling> getAllFillings() {
        return this.fillings;
    }
}
