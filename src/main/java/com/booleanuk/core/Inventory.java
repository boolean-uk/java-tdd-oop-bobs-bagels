package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    public static HashMap<String,Product> inventoryProducts;

    static {
        Product product = new Product("BGLO", "Bagel", 0.49, "Onion");
        Product product1 = new Product("BGLP", "Bagel", 0.39, "Plain");
        Product product2 = new Product("BGLE", "Bagel", 0.49, "Everything");
        Product product3 = new Product("BGLS", "Bagel", 0.49, "Sesame");

        Product product4 = new Product("FILB", "Filling", 0.12, "Bacon");

        Product product5 = new Product("FILE", "Filling", 0.12, "Egg");

        Product product6 = new Product("FILC", "Filling", 0.12, "Cheese");

        Product product7 = new Product("FILX", "Filling", 0.12, "Cream Cheese");

        Product product8 = new Product("FILS", "Filling", 0.12, "Smoked Salmon");

        Product product9 = new Product("FILH", "Filling", 0.12, "Ham");

        Product product10 = new Product("COFB", "Coffee", 0.99, "Black");
        Product product11 = new Product("COFW", "Coffee", 1.19, "White");
        Product product12 = new Product("COFC", "Coffee", 1.29, "Capuccino");
        Product product13 = new Product("COFL", "Coffee", 1.29, "Latte");


        inventoryProducts = new HashMap<>();
        inventoryProducts.put(product.getSKU(),product);
        inventoryProducts.put(product1.getSKU(),product1);
        inventoryProducts.put(product2.getSKU(),product2);
        inventoryProducts.put(product3.getSKU(),product3);
        inventoryProducts.put(product4.getSKU(),product4);
        inventoryProducts.put(product5.getSKU(),product5);
        inventoryProducts.put(product6.getSKU(),product6);
        inventoryProducts.put(product7.getSKU(),product7);
        inventoryProducts.put(product8.getSKU(),product8);
        inventoryProducts.put(product9.getSKU(),product9);
        inventoryProducts.put(product10.getSKU(),product10);
        inventoryProducts.put(product11.getSKU(),product11);
        inventoryProducts.put(product12.getSKU(),product12);
        inventoryProducts.put(product13.getSKU(),product13);
    }

    public  Inventory() {

    }

    public static boolean productIsInStock(String SKU){
        return inventoryProducts.containsKey(SKU);
    }
}
