package com.booleanuk.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;

public class Inventory {
    private final HashMap<String, String> baseProducts;
    private final HashMap<String, String> namesToSkus;
    private final LinkedHashMap<String, Product> skusToProducts;

    public Inventory(File file) {
        this.namesToSkus = new HashMap<>();
        this.skusToProducts = new LinkedHashMap<>();
        this.baseProducts = new HashMap<>();
        this.populateBaseData(file);
    }

    private void populateBaseData(File file) {
        try {
            Scanner myReader = new Scanner(file);
            String[] dataArr;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataArr = data.split(" ");
                baseProducts.put(dataArr[0],dataArr[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadProducts(File file) {
        try {
            Scanner myReader = new Scanner(file);
            String[] dataArr;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataArr = data.split(" ");
                Product product = new Product(dataArr[2].replace('_', ' '), Double.parseDouble(dataArr[1]), dataArr[0]);
                this.addNewProduct(product);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String constructProductName(String sku, String type) {
        String productName = baseProducts.getOrDefault(sku.substring(0,3), null);
        return productName == null? null: type + " " + productName;
    }

    public boolean addNewProduct(Product product) {
        if (skusToProducts.containsKey(product.getSku())) {
            return false;
        } else {
            String productName = constructProductName(product.getSku(), product.getType());
            if (productName == null) return false;
            namesToSkus.put(productName, product.getSku());
            skusToProducts.put(product.getSku(), product);
            return true;
        }
    }

    public String getProductList() {
        StringBuilder productList = new StringBuilder();
        for (String sku: skusToProducts.keySet()) {
            Product product = skusToProducts.get(sku);
            String productName = constructProductName(product.getSku(), product.getType());
            productList.append(product.getSku()).append(" | ").append(product.getCost()).append("$ | ").append(productName).append("\n");
        }
        if (Objects.equals(String.valueOf(productList), "")){
            return "Inventory empty.";
        }
        return String.valueOf(productList).substring(0,productList.length()-1);
    }

    private String searchProduct(String productName) {
        return namesToSkus.getOrDefault(productName, null);
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