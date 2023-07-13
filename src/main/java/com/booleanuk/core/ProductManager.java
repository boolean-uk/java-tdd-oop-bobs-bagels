package com.booleanuk.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductManager {
    private static final HashMap<String, Product> INVENTORY = fillHashMapFromFile("src/main/java/com/booleanuk/core/data/inventory.txt");
    private final Basket basket;

    public ProductManager() {
        basket = new Basket();
    }

    public HashMap<String, Product> getInventory() {
        return INVENTORY;
    }

    public boolean orderProduct(String variant) {
        if (basket.getList().size() < basket.getCapacity()) {
            for (Product product : INVENTORY.values()) {
                if (product.getVariant().equals(variant)) {
                    return basket.add(product);
                }
            }
            System.out.println("Failed to find the product");
            return false;
        }
        System.out.println("Can't add product. Basket is full!");
        return false;
    }

    public boolean removeProduct(String variant) {
        for (Product product : INVENTORY.values()) {
            if (product.getVariant().equals(variant)) {
                return basket.remove(product);
            }
        }
        System.out.println("Failed to remove the product");
        return false;
    }

    public void changeBasketCapacity(int capacity) {
        if (basket.setCapacity(capacity)) {
            System.out.println("Basket new capacity: " + basket.getCapacity());
        } else {
            System.out.println("Failed to change capacity");
        }
    }

    public ArrayList<Product> getItems() {
        return basket.getList();
    }

    public double getTotal() {
        return basket.total();
    }

    private static HashMap<String, Product> fillHashMapFromFile(String file) {
        HashMap<String, Product> hashMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4) {
                    String productCode = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String variant = parts[3].trim();
                    hashMap.put(productCode, new Product(name, price, variant));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
