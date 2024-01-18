package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    private String name;
    private ArrayList<String> fillings;
    public Bagel(String name) {
        this.name = name;
        fillings = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Bagel)) {
            return false;
        }
        Bagel other = (Bagel) obj;
        return this.name.equals(other.name);
    }

    public boolean addFilling(String filling) {
        filling = filling.toUpperCase();
        if(fillings.contains(filling)) {
            return false;
        }
        fillings.add(filling);
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean hasFilling(String filling) {
        return fillings.contains(filling.toUpperCase());
    }

    public ArrayList<String> getFillings() {
        return fillings;
    }
}
