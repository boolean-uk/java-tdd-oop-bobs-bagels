package com.booleanuk.core;

import java.util.HashMap;

public class Bagel {
    private HashMap<String, Filling> fillings;
    private String name;
    private double price;
    private String variant;


    public Bagel(String id){
//        switch (id){
//            case "BGLO":
//                this.
//        }
    }

    public double getPrice() {
        return price;
    }

    public HashMap<String, Filling> getFillings() {
        return fillings;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
