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

        // Filling items
        fillings.put("FILB", new Filling("FILB", 0.12, "Bacon"));
        fillings.put("FILE", new Filling("FILE", 0.12, "Egg"));
        fillings.put("FILC", new Filling("FILC", 0.12, "Cheese"));
        fillings.put("FILX", new Filling("FILX", 0.12, "Cream Cheese"));
        fillings.put("FILS", new Filling("FILS", 0.12, "Smoked Salmon"));
        fillings.put("FILH", new Filling("FILH", 0.12, "Ham"));

        // Bagel items
        bagels.put("BGLO", new Bagel("BGLO", 0.49, "Onion"));
        bagels.put("BGLP", new Bagel("BGLP", 0.39, "Plain"));
        bagels.put("BGLE", new Bagel("BGLE", 0.49, "Everything"));
        bagels.put("BGLS", new Bagel("BGLS", 0.49, "Sesame"));

        // Coffee items
        coffees.put("COFB", new Coffee("COFB", 0.99, "Black"));
        coffees.put("COFW", new Coffee("COFW", 1.19, "White"));
        coffees.put("COFC", new Coffee("COFC", 1.29, "Cappuccino"));
        coffees.put("COFL", new Coffee("COFL", 1.29, "Latte"));
    }
}
