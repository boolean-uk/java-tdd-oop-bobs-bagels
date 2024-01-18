package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{
    ArrayList<Filling> fillings;
    public Bagel(String name, String type, double price){
        super(name, type, price);
        fillings = new ArrayList<>();
    }
    public void addFillings(Filling f){
        fillings.add(f);
    }
    public ArrayList<Filling> getFillings(){
        return this.fillings;
    }

}
