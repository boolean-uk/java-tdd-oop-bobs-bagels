package com.booleanuk.core;

import java.util.HashMap;

public final class Inventory {

    private static HashMap<String, Bagel> bagels;
    private static HashMap<String, Coffee> coffees;
    private static HashMap<String, Filling> fillings;

    public Inventory(){
        fillings = new HashMap<>();
        coffees = new HashMap<>();
        bagels = new HashMap<>();
        populateMaps();
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
        return fillings.containsKey(id);
    }

    private void populateMaps(){
        fillings.put("FILB", new Filling("FILB"));
        fillings.put("FILE", new Filling("FILE"));
        fillings.put("FILC", new Filling("FILC"));
        fillings.put("FILX", new Filling("FILX"));
        fillings.put("FILS", new Filling("FILS"));
        fillings.put("FILH", new Filling("FILH"));
    }
}
