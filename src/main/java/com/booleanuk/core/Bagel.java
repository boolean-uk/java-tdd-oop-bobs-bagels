package com.booleanuk.core;

public class Bagel {
    private String name;
    public Bagel(String name) {
        this.name = name;
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
        return true;
    }
}
