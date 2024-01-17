package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;

public class Bagel implements Product {

    String bagel;
    String filling;
    double price;
    ArrayList<String> fillings = new ArrayList<>(Arrays.asList("Bacon", "Egg", "Cheese", "Cream Cheese", "Smoked Salmon", "Ham"));


    public Bagel(String name){
        this.bagel = name;
        this.price = 2.00;
        this.filling = "bland";
    }
    public Bagel(String name, double price){
        this.bagel = name;
        this.price = price;
        this.filling = "bland";
    }

    public boolean addFilling(String filling){
        if (fillings.contains(filling)){
            this.filling = filling;
            System.out.println("Filling " + this.filling + " added to bagel");
            return true;
        }
        System.out.println("Could not find filling in fillingList");
        return false;
    }

    @Override
    public String getName(){
        return this.bagel;
    }
    @Override
    public double getPrice(){
        return this.price;
    }

    public String getFilling(){
        return this.filling;
    }

}
