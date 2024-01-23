package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private final List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        products.add(new Bagel(0.49, "BGLO", "Onion"));
        products.add(new Bagel(0.39, "BGLP", "Plain"));
        products.add(new Bagel(0.49, "BGLE", "Everything"));
        products.add(new Bagel(0.49, "BGLS", "Sesame"));
        products.add(new Coffee(0.99, "COFB", "Black"));
        products.add(new Coffee(0.99, "COFW", "White"));
        products.add(new Filling(0.12, "FILB", "Bacon"));
        products.add(new Filling(0.12, "FILE", "Egg"));
        products.add(new Filling(0.12, "FILC", "Cheese"));
        products.add(new Filling(0.12, "FILX", "Cream Cheese"));
        products.add(new Filling(0.12, "FILS", "Smoked Salmon"));
        products.add(new Filling(0.12, "FILH", "Ham"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getItemBySku(String sku) {
        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }
    public boolean ProductInList(String SKU){
        for (Product product : products) {
            if (Objects.equals(product.getSku(), SKU)) {
                System.out.println("Product " + product.getVariant() + " " + product.getItemName() + " is in list");
                return true;
            }
        }
        System.out.println("Product not in list");
        return false;
    }
}