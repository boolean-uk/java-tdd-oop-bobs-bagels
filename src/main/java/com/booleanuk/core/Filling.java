package com.booleanuk.core;

public class Filling extends Item{
    FillingType variant;

    public Filling(FillingType variant) {
        //super(SKA, name);
        super();
        this.variant = variant;
    }

    @Override
    public String toString(){
        return variant.toString();
    }
}
