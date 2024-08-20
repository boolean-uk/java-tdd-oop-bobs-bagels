package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Bagel> bagels;
    private int basketSize;

    public Basket(int basketSize) {
        bagels = new ArrayList<>();
        this.basketSize = basketSize;
    }

    public int size() {
        return bagels.size();
    }

    public void addBagel(Bagel bagel) {
        if (bagels.size() < basketSize) {
            bagels.add(bagel);
        }
    }
}
