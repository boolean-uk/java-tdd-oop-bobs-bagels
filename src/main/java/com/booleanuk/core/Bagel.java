package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    private String name;
    private ArrayList<String> fillings;

    public Bagel(String name) {
        this.name = name.toUpperCase();
        fillings = new ArrayList<>();
    }

    public Bagel(String name, ArrayList<String> fillings) {
        this.name = name.toUpperCase();
        this.fillings = fillings;
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
        return new ArrayList<>(fillings);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Bagel)) {
            return false;
        }
        Bagel other = (Bagel) obj;
        return this.name.equalsIgnoreCase(other.name) && this.fillings.equals(other.fillings);
    }

    @Override
    public String toString() {
        return name + (fillings.isEmpty()? "": " with " + fillings);
    }
}
