package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

enum BAGELTYPE {
     ONION,
     PLAIN,
     EVERYTHING,
     SESAME
}

public class Bagel extends Item{

     final BAGELTYPE type;
     private ArrayList<Filling> fillings;

    public Bagel(BAGELTYPE type) {
        this.fillings=new ArrayList<>();
        this.type = type;
        switch (type){
            case ONION:         this.SKU = "BGLO"; this.price = 0.49; break;
            case PLAIN:         this.SKU = "BGLP"; this.price = 0.39; break;
            case EVERYTHING:    this.SKU = "GBLE"; this.price = 0.49; break;
            case SESAME:        this.SKU = "BGLS"; this.price = 0.49; break;
        }
    }

    public BAGELTYPE getType() {
        return type;
    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    public double getFillingsPrice() {
        double priceOfFillings=0;
        for (int i = 0; i < fillings.size(); i++) {
            priceOfFillings+=fillings.get(i).getPrice();
        }
        return priceOfFillings;
    }

    public void setFillings(Filling filling) {
        this.fillings.add(filling);
    }

    @Override
    public boolean getAvailable() {
        return BobsInvetory.isBagelInInvetory(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bagel bagel = (Bagel) o;
        return type == bagel.type && Objects.equals(fillings, bagel.fillings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fillings);
    }
}