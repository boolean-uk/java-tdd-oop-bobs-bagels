package com.booleanuk.core;

public class Filling extends Item{
    public static void main(String[] args) {
        Filling f = new Filling("Test", "123", FillingType.Bacon);
        System.out.println(f);
    }

    FillingType variant;

    public Filling(String SKA, String name, FillingType variant) {
        super(SKA, name);
        this.variant = variant;
    }

    @Override
    public String toString(){
        return variant.toString();
    }
}
