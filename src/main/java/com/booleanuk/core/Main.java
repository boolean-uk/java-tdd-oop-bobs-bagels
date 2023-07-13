package com.booleanuk.core;

import java.util.Scanner;

public class Main {
    private static ProductManager productManager = new ProductManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===== MENU =====");
            System.out.println("A - Order a bagel");
            System.out.println("B - Order a coffee");
            System.out.println("C - Remove product from the basket");
            System.out.println("D - Change basket capacity");
            System.out.println("E - Show basket");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    displayBagle();
                    break;
                case "B":
                    System.out.println("Remove bagel from the basket");
                    break;
                case "C":
                    System.out.println("Change basket capacity");
                    break;
                case "Q":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void displayBagle() {
        for (String string : productManager.getInventory().keySet()) {
            if (string.startsWith("B")) {
                System.out.println(productManager.getInventory().get(string));
            }
        }
        System.out.println("\nA - Order");
        System.out.println("Q - Exit");
        String choice = scanner.nextLine().trim().toUpperCase();
        switch (choice) {
            case "A" -> {
                boolean isAdd;
                do {

                    System.out.println("Type the variant:");
                    choice = scanner.nextLine().trim();
                    // Dodac obsluge bledow
                    isAdd = productManager.orderProduct(choice);
                } while (!isAdd);
                System.out.println("Do you want to add filling?");
                System.out.println("Y/N");
                choice = scanner.nextLine().trim().toUpperCase();
                if ("Y".equals(choice)) {
                    for (String sku : productManager.getInventory().keySet()) {
                        if (sku.startsWith("F")) {
                            System.out.println(productManager.getInventory().get(sku));
                        }
                    }
                    do {
                        System.out.println("Choose filling variant:");
                        choice = scanner.nextLine().trim();
                        productManager.orderProduct(choice);
                        System.out.println("Want to add next filling?");
                        System.out.println("Y/N");
                        choice = scanner.nextLine().trim().toUpperCase();
                    } while ("Y".equals(choice));
                }
            }
            case "Q" -> System.out.println("Returning to menu...");
        }
    }
}
