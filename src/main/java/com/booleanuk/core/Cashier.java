package com.booleanuk.core;

import java.util.Scanner;

public class Cashier {
    private Scanner userInput;
    private Basket basket;
    private Inventory inventory;

    public Cashier(Inventory inventory, Basket basket) {
        this.userInput = new Scanner(System.in);
        this.inventory = inventory;
        this.basket = basket;
    }

    private boolean doChoice(char choice, Scanner userInput) {
        boolean exit = false;
        switch (choice) {
            case 'v':
                inventory.printInventory(inventory.getBagelInventory(), "Bagel Inventory");
                inventory.printInventory(inventory.getCoffeeInventory(), "Coffee Inventory");
                inventory.printInventory(inventory.getFillingInventory(), "Filling Inventory");
                break;
            case 'a':
                System.out.print("Enter SKU of the product to add: ");
                String skuToAdd = userInput.next().trim().toUpperCase();
                System.out.print("Enter quantity to add: ");
                int quantityToAdd = userInput.nextInt();

                if (basket.addItems(inventory, skuToAdd, quantityToAdd)) {
                    System.out.println(quantityToAdd + " " + skuToAdd + "(s) added to the basket.");
                } else {
                    System.out.println("Unable to add items to the basket. Please check SKU and quantity.");
                }
                break;
            case 'r':
                System.out.print("Enter SKU of the product to remove: ");
                String skuToRemove = userInput.next().trim().toUpperCase();
                System.out.print("Enter quantity to remove: ");
                int quantityToRemove = userInput.nextInt();

                if (basket.removeItems(inventory, skuToRemove, quantityToRemove)) {
                    System.out.println(quantityToRemove + " " + skuToRemove + "(s) removed from the basket.");
                } else {
                    System.out.println("Unable to remove items from the basket. Please check SKU and quantity.");
                }
                break;
            case 'c':
                System.out.println(basket.showBasket());
                break;
            case 'p':
                // pay for basket
                break;
            case 'm':
                System.out.println("Enter ned capacity: ");
                int newCapacity = userInput.nextInt();
                if (basket.changeCapacity(newCapacity)){
                    System.out.println("Capacity changed");
                } else {
                    System.out.println("Not able to change capacity");
                }
                break;
            case 'x':
                menu();
                break;
            case 'q':
                exit = true;
                break;
            default:
                System.out.println("Invalid choice");
        }
        return exit;
    }

    private void menu() {
        System.out.println("v. View products");
        System.out.println("a. Add products");
        System.out.println("r. Remove products");
        System.out.println("c. Show basket");
        System.out.println("p. Pay for basket");
        System.out.println("m. Change capacity of basket");
        System.out.println("x. Back to menu");
        System.out.println("q. Exit");
        System.out.println("===========================");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        Basket basket = new Basket(10);
        Cashier cashier = new Cashier(inventory, basket);

        boolean exit = false;
        cashier.menu();
        while (!exit) {
            char choice = cashier.userInput.next().charAt(0);
            exit = cashier.doChoice(choice, cashier.userInput);
        }
    }
}
