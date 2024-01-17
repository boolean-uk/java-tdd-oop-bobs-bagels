package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Bagel> bagels;

    public Basket() {
        bagels = new ArrayList<Bagel>();
    }

    public ArrayList<Bagel> getBagels() {
        return bagels;
    }

    public void addBagel(Bagel bagel) {
        bagels.add(bagel);
    }
}
