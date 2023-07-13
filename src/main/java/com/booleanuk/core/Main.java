package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final ProductManager PRODUCT_MANAGER = new ProductManager();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===== MENU =====");
            System.out.println("A - Order a bagel");
            System.out.println("B - Order a coffee");
            System.out.println("C - Remove product from the basket");
            System.out.println("D - Change basket capacity");
            System.out.println("E - Show basket");
            System.out.println("F - Total cost");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");
            String choice = SCANNER.nextLine().trim().toUpperCase();
            System.out.println();

            switch (choice) {
                case "A" -> displayBagle();
                case "B" -> displayCoffee();
                case "C" -> displayRemove();
                case "D" -> displayCapacity();
                case "E" -> displayBasket();
                case "F" -> displayCost();
                case "Q" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        SCANNER.close();
    }

    private static void displayCost() {
        System.out.println("===== TOTAL =====");
        System.out.println("Total cost: " + PRODUCT_MANAGER.getTotal() + " GBP");
    }

    private static void displayBagle() {
        System.out.println("===== BAGLES =====");
        Set<String> skuList = PRODUCT_MANAGER.getInventory().keySet();
        for (String sku : skuList) {
            if (sku.startsWith("B"))
                System.out.println(PRODUCT_MANAGER.getInventory().get(sku).toStringExtended());
        }
        System.out.print("\nType a filling variant or click ENTER to exit: ");
        String choice = SCANNER.nextLine().trim();
        if (choice.isEmpty()) {
            System.out.println("Returning");
            return;
        }
        String choiceFormatted = choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
        if (!(PRODUCT_MANAGER.orderProduct(choiceFormatted))) {
            return;
        }

        System.out.println("\n===== FILLINGS =====");
        for (String sku : skuList) {
            if (sku.startsWith("F")) {
                System.out.println(PRODUCT_MANAGER.getInventory().get(sku).toStringExtended());
            }
        }
        System.out.println("\nDo you fancy yourself a filling?");
        System.out.print("Type a filling variant or click ENTER to exit: ");
        choice = SCANNER.nextLine().trim();
        if (choice.isEmpty()) {
            System.out.println("Returning");
            return;
        }
        choiceFormatted = choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
        do {
            PRODUCT_MANAGER.orderProduct(choiceFormatted);
            System.out.println("\nWant to add another filling?");
            System.out.print("Type a filling variant or click ENTER to exit: ");
            choice = SCANNER.nextLine().trim();
            if (choice.isEmpty()) {
                System.out.println("Returning");
                return;
            }
            choiceFormatted = choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
            System.out.println(choiceFormatted);
        } while (true);
    }

    private static void displayCoffee() {
        System.out.println("===== COFFEES =====");
        for (String sku : PRODUCT_MANAGER.getInventory().keySet()) {
            if (sku.startsWith("C")) {
                System.out.println(PRODUCT_MANAGER.getInventory().get(sku).toStringExtended());
            }
        }
        System.out.print("Type a coffee variant or click ENTER to exit: ");
        String choice = SCANNER.nextLine().trim();
        if (choice.isEmpty()) {
            System.out.println("Returning");
            return;
        }
        String choiceFormatted = choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
        PRODUCT_MANAGER.orderProduct(choiceFormatted);
    }

    private static void displayRemove() {
        System.out.println("===== REMOVE =====");
        if (displayBasket()) {
            System.out.println("Which item index to remove?");
            int choice = -1;
            try {
                choice = Integer.parseInt(SCANNER.nextLine().trim().toUpperCase());
            } catch (NumberFormatException ex) {
                System.out.println("Index has not been passed");
            }
            if (choice != -1 && choice < PRODUCT_MANAGER.getItems().size() && choice >= 0) {
                PRODUCT_MANAGER.getItems().remove(choice);
            } else {
                System.out.println("Failed to remove the item.");
            }
        }
    }

    private static void displayCapacity() {
        System.out.println("===== CAPACITY =====");
        System.out.println("Type new basket capacity:");
        int choice = -1;
        try {
            choice = Integer.parseInt(SCANNER.nextLine().trim().toUpperCase());
        } catch (NumberFormatException ex) {
            System.out.println("Capacity can not be changed");
        }
        if (choice != -1) {
            PRODUCT_MANAGER.changeBasketCapacity(choice);
        } else {
            System.out.println("Failed to change the capacity");
        }
    }

    private static boolean displayBasket() {
        System.out.println("===== BASKET =====");
        ArrayList<Product> basket = PRODUCT_MANAGER.getItems();
        if (basket.isEmpty()) {
            System.out.println("The basket is empty...");
            return false;
        } else {
            for (Product product : basket) {
                System.out.print(basket.indexOf(product) + " = ");
                System.out.println(product.toStringExtended());
            }
            return true;
        }
    }
}