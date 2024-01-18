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

    public static boolean isInInventory(String id){
        return (isBagel(id) || isCoffee(id)|| isFilling(id));
    }

    public static boolean isBagel(String id){
        return bagels.containsKey(id);
    }

    public static boolean isCoffee(String id){

        return coffees.containsKey(id);
    }
    public static boolean isFilling(String id){
        return fillings.containsKey(id);
    }

    public static HashMap<String, Bagel> getBagels() {
        return bagels;
    }

    public static HashMap<String, Coffee> getCoffees() {
        return coffees;
    }

    public static HashMap<String, Filling> getFillings() {
        return fillings;
    }

    private void populateMaps(){
        fillings.put("FILB", new Filling("FILB"));
        fillings.put("FILE", new Filling("FILE"));
        fillings.put("FILC", new Filling("FILC"));
        fillings.put("FILX", new Filling("FILX"));
        fillings.put("FILS", new Filling("FILS"));
        fillings.put("FILH", new Filling("FILH"));

        bagels.put("BGLO", new Bagel("BGLO"));
        bagels.put("BGLP", new Bagel("BGLP"));
        bagels.put("BGLE", new Bagel("BGLE"));
        bagels.put("BGLS", new Bagel("BGLS"));

        coffees.put("COFB", new Coffee("COFB"));
        coffees.put("COFW", new Coffee("COFW"));
        coffees.put("COFC", new Coffee("COFC"));
        coffees.put("COFL", new Coffee("COFL"));
    }
}
