package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    private ArrayList<Filling> fillings;
    private BagelType variant;

    public Bagel(String SKA, String name, BagelType variant) {
        super(SKA, name);
        this.variant = variant;
        fillings = new ArrayList<Filling>();
    }

    public BagelType getType(){
        return variant;
    }

    public ArrayList<Filling> getFillings(){
        return fillings;
    }

    public void addFilling(Filling filling){
        fillings.add(filling);
    }

    @Override
    public String toString(){
        return "Bagel: " + variant + " with " + fillings.toString();
    }

}
