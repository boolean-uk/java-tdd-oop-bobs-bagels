package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    private String variant = "";
    private ArrayList<String> fillings = new ArrayList<String>();


    public Bagel(String variant){
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public ArrayList<String> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<String> fillings) {
        this.fillings = fillings;
    }
}
