package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{

    private ArrayList<Filling> fillings;

    public Bagel(String SKU, int id) {
        fillings = new ArrayList<>();
        this.setName("Bagel");
        this.setId(id);
        switch (SKU){
            case "BGLO": {
                this.setSKU(SKU);
                this.setVariant("Onion");
                this.setPrice(0.49);
                break;
            }
            case "BGLP": {
                this.setSKU(SKU);
                this.setVariant("Plain");
                this.setPrice(0.39);
                break;
            }
            case "BGLE": {
                this.setSKU(SKU);
                this.setVariant("Everything");
                this.setPrice(0.49);
                break;
            }
            case "BGLS": {
                this.setSKU(SKU);
                this.setVariant("Sesame");
                this.setPrice(0.49);
                break;
            }
        }
    }
}
