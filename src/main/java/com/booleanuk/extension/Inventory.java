package com.booleanuk.extension;

import java.util.HashMap;

public final class Inventory {

    private static HashMap<String, Product> products;

    static {
        // Initialize maps in the static block
        products = new HashMap<>();
        populateMaps();
    }
    private Inventory(){

    }

    public static Product getProductById(String id){
        return products.get(id);
    }
    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static boolean isValidProduct(Product product){
        Product inventoryProduct = products.get(product.getId());
        return inventoryProduct != null && inventoryProduct.getPrice() == product.getPrice() && inventoryProduct.getVariant().equals(product.getVariant());
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
