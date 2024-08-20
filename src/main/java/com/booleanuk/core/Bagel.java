package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    public static void main(String[] args) {
        System.out.println("hei fra bagel main");
    }
    private ArrayList<FillingType> fillings;
    private BagelType variant;

    public Bagel(BagelType variant) {
        super();
        this.variant = variant;
        fillings = new ArrayList<>();
    }

    public BagelType getType(){
        return variant;
    }

    public ArrayList<FillingType> getFillings(){
        return fillings;
    }

    public void addFilling(FillingType filling){
        fillings.add(filling);
    }

    @Override
    public String toString(){
        return "Bagel: " + variant + " with " + fillings.toString();
    }

}
