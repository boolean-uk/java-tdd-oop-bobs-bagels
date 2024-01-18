package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {

    private static HashMap<String, Bagel> bagels;
    private static HashMap<String, Coffee> coffees;
    private static HashMap<String, Filling> fillings;

    public Inventory(){

    }

    public boolean isInInventory(String id){
        return false;
    }

    public boolean isBagel(String id){
        return false;
    }

    public boolean isCoffee(String id){
        return false;
    }
    public boolean isFilling(String id){
        return false;
    }

}
