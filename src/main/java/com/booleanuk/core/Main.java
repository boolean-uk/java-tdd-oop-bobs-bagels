package com.booleanuk.core;

import java.util.ArrayList;
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
            System.out.println("F - Total cost");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    displayBagle();
                    break;
                case "B":
                    displayCoffee();
                    break;
                case "C":
                    displayRemove();
                    break;
                case "D":
                    displayCapacity();
                    break;
                case "E":
                    displayBasket();
                    break;
                case "F":
                    displayCost();
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

    private static void displayCost() {
        System.out.println("Total cost: " + productManager.getBasket().total() + " GBP");
    }

    private static void displayBagle() {
        for (String string : productManager.getInventory().keySet()) {
            if (string.startsWith("B")) {
                System.out.println(productManager.getInventory().get(string));
            }
        }
        System.out.println("\nType a bagle variant or Q for exit.");
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

    private static void displayCoffee() {
        for (String string : productManager.getInventory().keySet()) {
            if (string.startsWith("C")) {
                System.out.println(productManager.getInventory().get(string));
            }
        }
        System.out.println("Type the variant or Q for exit:");
        String choice = scanner.nextLine().trim();
        //todo Bug z wyjsciem
        if (!(choice.equals("Q")) || !(choice.equals("q"))){
            productManager.orderProduct(choice);
        }
    }

    private static void displayRemove() {
        if (displayBasket()) {
            System.out.println("Which item index to remove?");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim().toUpperCase());
            } catch (NumberFormatException ex) {
                System.out.println("Index has not been passed");
            }
            if (choice != -1 && choice < productManager.getBasket().getList().size() && choice >= 0) {
                productManager.getBasket().getList().remove(choice);
            } else {
                System.out.println("Failed to remove the item.");
            }
        }
    }

    private static void displayCapacity() {
        System.out.println("Type new basket capacity:");
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim().toUpperCase());
        } catch (NumberFormatException ex) {
            System.out.println("Capacity can not be changed");
        }
        if (choice != -1) {
            productManager.changeBasketCapacity(choice);
        } else {
            System.out.println("Failed to change the capacity");
        }
    }

    private static boolean displayBasket() {
        ArrayList<Product> basket = productManager.getBasket().getList();
        if (basket.isEmpty()) {
            System.out.println("The basket is empty...");
            return false;
        } else {
            for (Product product : basket) {
                System.out.print(basket.indexOf(product) + " = ");
                System.out.println(product);
            }
            return true;
        }
    }
}
