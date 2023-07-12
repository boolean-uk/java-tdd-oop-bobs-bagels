package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> inventoryList;

    public Inventory() {
        inventoryList = new ArrayList<>();
        //bagel
        inventoryList.add(new Product("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Product("BGLP", 0.39, "Bagel", "Plain"));
        inventoryList.add(new Product("BGLE", 0.49, "Bagel", "Everything"));
        inventoryList.add(new Product("BGLS", 0.49, "Bagel", "Sesame"));
        //coffee
        inventoryList.add(new Product("COFB", 0.99, "Coffee", "Black"));
        inventoryList.add(new Product("COFW", 1.19, "Coffee", "White"));
        inventoryList.add(new Product("COFC", 1.29, "Coffee", "Capuccino"));
        inventoryList.add(new Product("COFL", 1.29, "Coffee", "Latte"));
        //filling
        inventoryList.add(new Product("FILB", 0.12, "Filling", "Bacon"));
        inventoryList.add(new Product("FILE", 0.12, "Filling", "Egg"));
        inventoryList.add(new Product("FILC", 0.12, "Filling", "Cheese"));
        inventoryList.add(new Product("FILX", 0.12, "Filling", "Cream Cheese"));
        inventoryList.add(new Product("FILS", 0.12, "Filling", "Smoked Salmon"));
        inventoryList.add(new Product("FILH", 0.12, "Filling", "Ham"));
    }

    public List<Product> getInventoryList() {
        return inventoryList;
    }

    public Product getProductBySKU(String sku) {
            return inventoryList.stream().filter(e -> e.getSku().equals(sku)).findFirst().orElse(null);
    }

    public Product getProductByNameAndVariant(String name, String variant) {
        return inventoryList.stream().filter(e -> (e.getName().equals(name)&&e.getVariant().equals(variant))).findFirst().orElse(null);
    }

    public double getPriceBySKU(String sku) {
        if(inventoryList.stream().anyMatch(e -> e.getSku().equals(sku))){
            return inventoryList.stream().filter(e -> e.getSku().equals(sku)).findFirst().get().getPrice();
        }else return 0;
    }

    public double getPriceByNameAndVariant(String name, String variant) {
        if(inventoryList.stream().anyMatch(e -> (e.getName().equals(name)&&e.getVariant().equals(variant)))){
            return inventoryList.stream().filter(e -> (e.getName().equals(name)&&e.getVariant().equals(variant))).findFirst().get().getPrice();
        }else return 0;
    }
}
