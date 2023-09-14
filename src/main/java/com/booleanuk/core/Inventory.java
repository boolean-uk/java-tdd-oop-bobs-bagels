package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private final HashMap<String, String> nameToSkus;
    private final HashMap<String, Product> skusToProducts;

    public Inventory() {
        this.nameToSkus = new HashMap<>();
        this.skusToProducts = new HashMap<>();
    }

    public boolean addNewProduct(Product product) {
        if (skusToProducts.containsKey(product.getSku())) {
            return false;
        } else {
            skusToProducts.put(product.getSku(), product);
            String productName = constructProductName(product.getSku(), product.getType());
            nameToSkus.put(productName, product.getSku());
            return true;
        }
    }

    private String constructProductName(String sku, String type) {
        String productName = type + " ";
        switch (sku.substring(0,3)){
            case "BGL" -> productName += "Bagel";
            case "COF" -> productName += "Coffee";
            case "FIL" -> productName += "Filling";
        }
        return productName;
    }

    public String getProductList() {
        StringBuilder productList = new StringBuilder();
        for (String sku: skusToProducts.keySet()) {
            Product product = skusToProducts.get(sku);
            String productName = constructProductName(product.getSku(), product.getType());
            productList.append(product.getSku()).append(" | ").append(productName).append(" | ").append(product.getCost()).append("$\n");
        }
        return String.valueOf(productList).substring(0,productList.length()-1);
    }

    private String searchProduct(String productName) {
        return nameToSkus.getOrDefault(productName, null);
    }

    public Product getProductByName(String productName) {
        String sku = searchProduct(productName);
        if (sku == null) {
            return null;
        } else {
            Product tmp = skusToProducts.get(sku);
            return new Product(tmp.getType(), tmp.getCost(), tmp.getSku());
        }
    }
}
