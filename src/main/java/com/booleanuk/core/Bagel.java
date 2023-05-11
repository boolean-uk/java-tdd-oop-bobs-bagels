package com.booleanuk.core;



import java.util.ArrayList;
import java.util.List;

public class Bagel {
    private String type;
    private double price;
    private List<Filling> fillings;

    public Bagel(String type, double price, List<Filling> fillings){
        this.type = type;
        this.price = price;
        this.fillings = fillings;
    }

    public Bagel(String type, double price){
        this.type = type;
        this.price = price;
        this.fillings = new ArrayList<>();
    }

    public String getType(){
        return "";
    }

    public double getPrice(){
        return 0.0;
    }

    public boolean addFilling(Filling filling){

        return true;
    }




}
