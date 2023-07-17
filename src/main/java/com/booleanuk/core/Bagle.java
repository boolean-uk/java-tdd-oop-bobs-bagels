package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagle extends Product{


    public List<String> fillings;

    public Bagle(String SKU, double price, String variant) {
        super(SKU, price, variant);
        this.fillings = new ArrayList<>();
    }



    public void addFilling(String filling) {
        fillings.add(filling);
    }
    public void removeFilling(String filling) {
        fillings.remove(filling);
    }

    public List<String> getFillings() {
        return fillings;
    }



}
