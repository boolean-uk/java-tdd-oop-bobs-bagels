package com.booleanuk.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
    private HashMap<String, Product> inventory;
    private Basket basket;

    public ProductManager() {
        inventory = fillHashMapFromFile("src/main/java/com/booleanuk/core/inventory.txt");
        basket = new Basket(10);
    }

    public boolean orderBagel(String variant) {
        if (basket.getList().size() < basket.getCapacity()) {
            for (Map.Entry<String, Product> entry : inventory.entrySet()) {
                if (entry.getValue().getVariant().equals(variant)) {
                    return basket.add(entry.getValue());
                }
            }
            System.out.println("Failed to find the product");
            return false;
        }
        System.out.println("Can't add product. Basket is full!");
        return false;
    }

    public boolean removeBagel(String variant) {
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            if (entry.getValue().getVariant().equals(variant)) {
                return basket.remove(entry.getValue());
            }
        }
        System.out.println("Failed to remove the product");
        return false;
    }

    public HashMap<String, Product> getInventory() {
        return inventory;
    }

    private HashMap<String, Product> fillHashMapFromFile(String file) {
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

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("===== MENU =====");
            System.out.println("A - Order a bagel");
            System.out.println("B - Remove bagel from the basket");
            System.out.println("C - Change basket capacity");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A" -> System.out.println("Order a bagel");
                case "B" -> System.out.println("Remove bagel from the basket");
                case "C" -> System.out.println("Change basket capacity");
                case "Q" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    public Basket getBasket() {
        return basket;
    }

    public void changeBasketSize(int size) {
        basket.setCapacity(size);
    }
}
