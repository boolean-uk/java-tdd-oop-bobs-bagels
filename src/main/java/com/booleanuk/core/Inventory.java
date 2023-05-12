package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public HashMap<String,Product> products;

    Product product = new Product("BGLO","Bagel",0.49,"Onion");
    Product product1 = new Product("BGLP","Bagel",0.39,"Plain");
    Product product2 = new Product("BGLE","Bagel",0.49,"Everything");
    Product product3 = new Product("BGLS","Bagel",0.49,"Sesame");

    Product product4 = new Product("FILB","Filling",0.12,"Bacon");

    Product product5 = new Product("FILE","Filling",0.12,"Egg");

    Product product6 = new Product("FILC","Filling",0.12,"Cheese");

    Product product7 = new Product("FILX","Filling",0.12,"Cream Cheese");

    Product product8 = new Product("FILS","Filling",0.12,"Smoked Salmon");

    Product product9 = new Product("FILH","Filling",0.12,"Ham");

    Product product10 = new Product("COFB", "Coffee", 0.99, "Black");
    Product product11 = new Product("COFW", "Coffee", 1.19, "White");
    Product product12 = new Product("COFC", "Coffee", 1.29, "Capuccino");
    Product product13 = new Product("COFL", "Coffee", 1.29, "Latte");



    public Inventory() {
        this.products = new HashMap<>();
        products.put(product.getSKU(),product);
        products.put(product1.getSKU(),product1);
        products.put(product2.getSKU(),product2);
        products.put(product3.getSKU(),product3);
        products.put(product4.getSKU(),product4);
        products.put(product5.getSKU(),product5);
        products.put(product6.getSKU(),product6);
        products.put(product7.getSKU(),product7);
        products.put(product8.getSKU(),product8);
        products.put(product9.getSKU(),product9);
        products.put(product10.getSKU(),product10);
        products.put(product11.getSKU(),product11);
        products.put(product12.getSKU(),product12);
        products.put(product13.getSKU(),product13);
    }

    public boolean productIsInStock(String SKU){
        return products.containsKey(SKU);
    }
}
