package com.booleanuk.core;

import java.util.HashMap;

public final class Inventory {

    private static HashMap<String, Product> products;

    static {
        products = new HashMap<>();
        populateMaps();
    }
    private Inventory(){
    }

    public static HashMap<String, Product> getProducts(){
        return products;
    }

    public static boolean isValidProduct(Product product){
        Product inventoryproduct = products.get(product.getId());
        return inventoryproduct != null && inventoryproduct.getPrice() == product.getPrice() && inventoryproduct.getVariant().equals(product.getVariant());
    }

    private static void populateMaps(){
        // Filling items
        products.put("FILB", new Filling("FILB", 0.12, "Bacon"));
        products.put("FILE", new Filling("FILE", 0.12, "Egg"));
        products.put("FILC", new Filling("FILC", 0.12, "Cheese"));
        products.put("FILX", new Filling("FILX", 0.12, "Cream Cheese"));
        products.put("FILS", new Filling("FILS", 0.12, "Smoked Salmon"));
        products.put("FILH", new Filling("FILH", 0.12, "Ham"));

        // Bagel items
        products.put("BGLO", new Bagel("BGLO", 0.49, "Onion"));
        products.put("BGLP", new Bagel("BGLP", 0.39, "Plain"));
        products.put("BGLE", new Bagel("BGLE", 0.49, "Everything"));
        products.put("BGLS", new Bagel("BGLS", 0.49, "Sesame"));

        // Coffee items
        products.put("COFB", new Coffee("COFB", 0.99, "Black"));
        products.put("COFW", new Coffee("COFW", 1.19, "White"));
        products.put("COFC", new Coffee("COFC", 1.29, "Cappuccino"));
        products.put("COFL", new Coffee("COFL", 1.29, "Latte"));
    }
}

//    public static boolean isInInventory(String id){
//        return (isValidBagel() || isValidCoffee()|| isValidFilling());
//    }

//    public static boolean isValidBagel(Bagel bagel){
//        Bagel inventoryBagel = bagels.get(bagel.getId());
//        return inventoryBagel != null && inventoryBagel.getPrice() == bagel.getPrice() && inventoryBagel.getVariant().equals(bagel.getVariant());
//    }
//
//    public static boolean isValidCoffee(Coffee coffee){
//        Coffee inventoryCoffee = coffees.get(coffee.getId());
//        return inventoryCoffee!= null && inventoryCoffee.getPrice() == coffee.getPrice() && inventoryCoffee.getVariant().equals(coffee.getVariant());
//    }
//    public static boolean isValidFilling(Filling filling){
//        Filling inventoryFilling = fillings.get(filling.getId());
//        return inventoryFilling!= null && inventoryFilling.getPrice() == filling.getPrice() && inventoryFilling.getVariant().equals(filling.getVariant());
//    }

//    public static HashMap<String, Bagel> getBagels() {
//        return bagels;
//    }
//
//    public static HashMap<String, Coffee> getCoffees() {
//        return coffees;
//    }
//
//    public static HashMap<String, Filling> getFillings() {
//        return fillings;
//    }


// Initialize maps in the static block
//        fillings = new HashMap<>();
//        coffees = new HashMap<>();
//        bagels = new HashMap<>();



//    private static HashMap<String, Bagel> bagels;
//    private static HashMap<String, Coffee> coffees;
//    private static HashMap<String, Filling> fillings;