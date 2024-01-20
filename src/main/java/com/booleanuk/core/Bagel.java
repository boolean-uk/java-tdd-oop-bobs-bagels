package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Bagel extends Item{
    private ArrayList<Filling> fillings;

    public Bagel(String name) {
        super(name);
        fillings = new ArrayList<>();
    }

    public Bagel(String name, ArrayList<Filling> fillings) {
        super(name);
        this.fillings = Objects.requireNonNullElseGet(fillings, ArrayList::new);
    }

    public ArrayList<Filling> getFillings() {
        return new ArrayList<>(fillings);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Bagel)) {
            return false;
        }
        Bagel other = (Bagel) obj;
        return super.equals(other) && this.fillings.equals(other.fillings);
    }

    @Override
    public String toString() {
        return super.getName() + (fillings.isEmpty()? "": " with " + fillings);
    }
}
