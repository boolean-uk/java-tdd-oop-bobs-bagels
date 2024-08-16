package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    ArrayList<Filling> fillings;
    BagelType variant;

    public Bagel(double price, String SKA, String name, BagelType variant) {
        super(price, SKA, name);
        this.variant = variant;
        fillings = new ArrayList<Filling>();

    }


}
