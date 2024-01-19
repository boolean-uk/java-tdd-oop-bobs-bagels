package com.booleanuk.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private HashMap<String, Item> bagelInventory = new HashMap<>();
    private HashMap<String, Item> fillingInventory = new HashMap<>();
    private HashMap<String, Item> coffeeInventory = new HashMap<>();

    public Inventory(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split(",");

                String sku = values[0].trim();
                double price = Double.parseDouble(values[1].trim());
                String name = values[2].trim();
                String variant = values[3].trim();

                Item item = new Item(sku, name, price, variant);

                switch (name) {
                    case "Bagel":
                        bagelInventory.put(sku, item);
                        break;
                    case "Filling":
                        fillingInventory.put(sku, item);
                        break;
                    case "Coffee":
                        coffeeInventory.put(sku, item);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Item> getBagelInventory() {
        return bagelInventory;
    }
    public HashMap<String, Item> getFillingInventory() {
        return fillingInventory;
    }
    public HashMap<String, Item> getCoffeeInventory() {
        return coffeeInventory;
    }
    public void printInventory(HashMap<String, Item> inventory, String inventoryName) {
        System.out.println("\n" + inventoryName + ":");
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            String sku = entry.getKey();
            Item item = entry.getValue();
            System.out.println("SKU: " + sku + ", Variant: " + item.getVariant() + ", Price: " + item.getPrice());
        }
        System.out.println("-------------------------------");
    }
    public Item getItemBySKU(String sku) {
        if (sku.length() >= 3) {
            String inventoryType = sku.substring(0, 3);
            switch (inventoryType) {
                case "BGL":
                    return bagelInventory.get(sku);
                case "COF":
                    return coffeeInventory.get(sku);
                case "FIL":
                    return fillingInventory.get(sku);
            }
        }
        return null;
    }
    public double getBagelPrice(String type) {
        return bagelInventory.get(type).getPrice();
    }
    public double getFillingPrice(String type) {
        return fillingInventory.get(type).getPrice();
    }
    public double getCoffeePrice(String type) {
        return coffeeInventory.get(type).getPrice();
    }
}
