package com.booleanuk.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductManager {
    private static final List<Product> INVENTORY = fillList("src/main/java/com/booleanuk/core/data/inventory.txt");
    private final Basket basket;

    public ProductManager() {
        basket = new Basket();
    }

    public List<Product> getInventory() {
        return INVENTORY;
    }

    public Product orderProduct(String variant) {
        if (basket.getList().size() < basket.getCapacity()) {
            for (Product product : INVENTORY) {
                if (product.getVariant().equals(variant)) {
                    basket.add(product);
                    return product;
                }
            }
            System.out.println("Failed to find the product");
            return null;
        }
        System.out.println("Can't add product. Basket is full!");
        return null;
    }

    public boolean removeProduct(String variant) {
        for (Product product : INVENTORY) {
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

    public int getBasketCapacity() {
        return basket.getCapacity();
    }

    public ArrayList<Product> getItems() {
        return basket.getList();
    }

    public double getTotal() {
        return basket.total();
    }

    private static List<Product> fillList(String file) {
        List<Product> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4) {
                    String productCode = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String variant = parts[3].trim();
                    if (productCode.startsWith("B")) {
                        list.add(new Bagel(name, price, variant));
                    } else if (productCode.startsWith("F")) {
                        list.add(new Filling(name, price, variant));
                    } else if (productCode.startsWith("C")) {
                        list.add(new Coffee(name, price, variant));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
