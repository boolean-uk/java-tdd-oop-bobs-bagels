package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item {

    private ArrayList<String> fillings;

    public Bagel(String name, String sKU) {
        super(name, sKU);
        this.fillings = new ArrayList<>();
    }

    public ArrayList<String> getFillings() {
        return this.fillings;
    }

    public void addFilling(String filling) {
        this.fillings.add(filling);
    }
}
